package modules;

public class PessoaFisica extends Pessoa {
	private long cpf;

	public PessoaFisica(String name, long cpf) {
		super(name);
		this.cpf = cpf;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	

	
	

	

	
	
	

}
