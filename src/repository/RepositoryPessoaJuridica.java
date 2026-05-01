package repository;

import java.util.ArrayList;
import java.util.List;

import modules.Pessoa;
import modules.PessoaJuridica;

public class RepositoryPessoaJuridica implements IRepositoryCRUD {
	List<PessoaJuridica> listPJ = new ArrayList<PessoaJuridica>();

	@Override
	public boolean create(Pessoa pessoa) {
		if (pessoa instanceof PessoaJuridica) {
			listPJ.add((PessoaJuridica) pessoa);
			return true;
		}
		return false;
	}

	@Override
	public List<PessoaJuridica> read() {
		return listPJ;
	}

	@Override
	public boolean update(Pessoa pessoa) {
		boolean check = false;
		if (pessoa instanceof PessoaJuridica) {
			PessoaJuridica pj = (PessoaJuridica) pessoa;
			for(int i = 0; i < listPJ.size(); i++) {
				if(listPJ.get(i).getCnpj() == pj.getCnpj()) {
					listPJ.get(i).setName(pj.getName());
					check = true;
				}
			}
		}
		return check;
	}

	@Override
	public boolean delete(long id) {
		boolean check = false;
		for(int i = 0; i < listPJ.size(); i++) {
			if(listPJ.get(i).getCnpj() == id) {
				listPJ.remove(i);
				check = true;
			}
		}
		return check;
	}
	
}
