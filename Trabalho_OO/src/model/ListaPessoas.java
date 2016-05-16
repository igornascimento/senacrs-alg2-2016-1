package model;

public class ListaPessoas {
	private static final int MAX_PESSOAS = 10;
	private int countPessoas;
	private Pessoa[] pessoas;
	
	public ListaPessoas() {
		pessoas = new Pessoa[MAX_PESSOAS];
	}
	
	public void incluiPessoa(Pessoa pessoa) {
		if (countPessoas < MAX_PESSOAS) {
			pessoas[countPessoas] = pessoa;
			countPessoas++;
		}	
	}

	public void excluiPessoa(String nome) {
		for (int i = 0; i < countPessoas; i++) {
			Pessoa p = pessoas[i];
			if (nome.equals(p.getNome())) {
				countPessoas--;
				pessoas[i] = pessoas[countPessoas];
				pessoas[countPessoas] = null;
			}
		}
	}

	public Pessoa pesquisaPessoa(String nome) {
		for (int i = 0; i < countPessoas; i++) {
			Pessoa p = pessoas[i];
			if (nome.equals(p.getNome())) {
				return p;
			}
		}
		return null;
	}

}
