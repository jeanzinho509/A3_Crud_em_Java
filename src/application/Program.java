package application;

import java.util.Scanner;

import modules.PessoaFisica;
import modules.PessoaJuridica;
import repository.RepositoryPessoaFisica;
import repository.RepositoryPessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int binary = 0;
		RepositoryPessoaFisica rpf = new RepositoryPessoaFisica();
		RepositoryPessoaJuridica rpj = new RepositoryPessoaJuridica();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("| Trabalho de gestao e qualidade de software |");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("---------------------------------");
		System.out.println("|    Parte 1 da avaliacao A3    |");
		System.out.println("---------------------------------\n");
		System.out.println("********************************");
		System.out.println("| Aluno: Jean Woodly Estime |");
		System.out.println("| RA: 1262215856             |");
		System.out.println("********************************\n");
		
		while(binary == 0) {					
		System.out.println("Escolha a opcao de 1 a 9\n");
		System.out.println("1 - Cadastrar Pessoa Fisica");
		System.out.println("2 - Cadastrar Pessoa Juridica");
		System.out.println("3 - Atualizar nome Pessoa Fisica");
		System.out.println("4 - Atualizar nome Pessoa Juridica");
		System.out.println("5 - Remover Pessoa Fisica");
		System.out.println("6 - Remover Pessoa Juridica");
		System.out.println("7 - Listar Pessoas Fisica");
		System.out.println("8 - Listar Pessoas Juridica");
		System.out.println("9 - Sair do menu\n");

		int choice = -1;
		while (choice < 1 || choice > 9) {
			System.out.print("Sua escolha: ");
			try {
				choice = Integer.parseInt(input.nextLine());
				if (choice < 1 || choice > 9) {
					System.out.println("Essa Opcao nao e valida\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada invalida. Por favor, digite um numero.\n");
			}
		}

		if (choice == 1) {
			System.out.print("\nNome: ");
			String name = input.nextLine();
			System.out.print("CPF: ");
			long cpf = readLong(input);
			PessoaFisica pf = new PessoaFisica(name, cpf);
			rpf.create(pf);
		}
		else if (choice == 2) {
			System.out.print("\nNome: ");
			String name = input.nextLine();
			System.out.print("CNPJ: ");
			long cnpj = readLong(input);
			PessoaJuridica pj = new PessoaJuridica(name, cnpj);
			rpj.create(pj);
		} else if (choice == 3) {
			System.out.print("\nPor favor Escolha um novo nome: ");
			String name = input.nextLine();
			System.out.print("CPF: ");
			long cpf = readLong(input);
			PessoaFisica pf = new PessoaFisica(name, cpf);
			rpf.update(pf);
		} else if (choice == 4) {
			System.out.print("\nEscolha um novo nome: ");
			String name = input.nextLine();
			System.out.print("CNPJ: ");
			long cnpj = readLong(input);
			PessoaJuridica pj = new PessoaJuridica(name, cnpj);
			rpj.update(pj);
		} else if (choice == 5) {
			System.out.print("\nDigite o CPF da pessoa que quer deletar: ");
			long cpf = readLong(input);
			rpf.delete(cpf);
		} else if (choice == 6) {
			System.out.print("\nDigite o CNPJ da pessoa que quer deletar: ");
			long cnpj = readLong(input);
			rpj.delete(cnpj);
		} else if (choice == 7) {
			System.out.println("\nLista:");
			for(int i = 0; i < rpf.read().size(); i++) {
				PessoaFisica pf = (PessoaFisica) rpf.read().get(i);
				System.out.println("\n+++++++++++++++++++++++++++++");
				System.out.println("Nome: " + pf.getName());
				System.out.println("cpf: " + pf.getCpf() + "\n");	
			}
		} else if (choice == 8) {
			System.out.println("Lista:");
			for(int i =0; i < rpj.read().size(); i++) {
				PessoaJuridica pj = (PessoaJuridica) rpj.read().get(i);
				System.out.println("\n+++++++++++++++++++++++++++++");
				System.out.println("Nome: " + pj.getName());
				System.out.println("CNPJ: " + pj.getCnpj() + "\n");	
			}
		} else {
			System.out.println(" ---- Menu out ----");
		}

		if (choice != 9) {
			System.out.println("\nDigite 1 para voltar ao menu\nDigite 2 para sair");
			int option = -1;
			while (option != 1 && option != 2) {
				System.out.print("\nOperacao desejada: ");
				try {
					option = Integer.parseInt(input.nextLine());
					if (option != 1 && option != 2) {
						System.out.println("Opcao invalida.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Entrada invalida. Por favor, digite 1 ou 2.");
				}
			}
			if (option == 2) {
				binary = 1;
			}
		} else {
			binary = 1;
		}
		}
		System.out.println("\n+++++++++++++++++++++++");
		System.out.println("|  GOD BLESS ALL OF US  |");
		System.out.println("+++++++++++++++++++++++");
		input.close();
	}

	private static long readLong(Scanner input) {
		while (true) {
			try {
				return Long.parseLong(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.print("Entrada invalida. Por favor, digite um numero: ");
			}
		}
	}

}
