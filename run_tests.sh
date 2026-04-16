#!/bin/bash
# run_tests.sh - Run project tests

# Attempt to find JUnit and Hamcrest in common locations
# These can also be overridden by setting JUNIT_JAR and HAMCREST_JAR environment variables
JUNIT_JAR=${JUNIT_JAR:-$(find /usr/share/gradle-8.8/lib -name "junit-4*.jar" | head -n 1)}
HAMCREST_JAR=${HAMCREST_JAR:-$(find /usr/share/gradle-8.8/lib -name "hamcrest-core-*.jar" | head -n 1)}

if [ -z "$JUNIT_JAR" ] || [ -z "$HAMCREST_JAR" ]; then
    echo "Error: JUnit or Hamcrest JAR not found. Please set JUNIT_JAR and HAMCREST_JAR environment variables."
else
    CLASSPATH="src:bin:$JUNIT_JAR:$HAMCREST_JAR"

    echo "Compiling..."
    mkdir -p bin
    javac -d bin -cp "$CLASSPATH" src/modules/*.java src/repository/*.java

    echo "Running tests..."
    java -cp "$CLASSPATH:bin" org.junit.runner.JUnitCore repository.RepositoryPessoaFisicaTest
fi
