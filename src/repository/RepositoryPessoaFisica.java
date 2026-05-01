package repository;

import java.util.ArrayList;
import java.util.List;

import modules.Pessoa;
import modules.PessoaFisica;

public class RepositoryPessoaFisica implements IRepositoryCRUD{
	List<PessoaFisica> listPF = new ArrayList<PessoaFisica>();
	
	@Override
	public boolean create(Pessoa pessoa) {
		if (pessoa instanceof PessoaFisica) {
			listPF.add((PessoaFisica) pessoa);
			return true;
		}
		return false;
	}

	@Override
	public List<PessoaFisica> read() {
		return listPF;
	}

	@Override
	public boolean update(Pessoa pessoa) {
		boolean check = false;
		if (pessoa instanceof PessoaFisica) {
			PessoaFisica pf = (PessoaFisica) pessoa;
			for (int i = 0; i < listPF.size(); i++) {
				if (listPF.get(i).getCpf() == pf.getCpf()) {
					listPF.get(i).setName(pf.getName());
					check = true;
				}
			}
		}
		return check;
	}

	@Override
	public boolean delete(long id) {
		boolean check = false;
		for (int i = 0; i < listPF.size(); i++) {
			if (listPF.get(i).getCpf() == id) {
				listPF.remove(i);
				check = true;
			}
		}
		return check;
	}
	
	
}
