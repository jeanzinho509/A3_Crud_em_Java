package modules;

public class PessoaJuridica extends Pessoa {
	private long cnpj;

	public PessoaJuridica(String name, long cnpj) {
		super(name);
		this.cnpj = cnpj;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}


	
	
	
}
