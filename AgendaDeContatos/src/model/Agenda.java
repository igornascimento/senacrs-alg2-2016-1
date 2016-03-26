package model;

/**
 * Implementa um modelo de Agenda de Contatos capaz de
 * gerenciar um conjunto de objetos do tipo Contato.
 */
public class Agenda {

	private final int MAXIMO = 5;

	private Contato[] contatos = new Contato[MAXIMO];
	private int totalContatos = 0;

	/**
	 * Adiciona um novo contato na Agenda.
	 * @param contato O contato a ser adicionado.
	 */
	public void adiciona(Contato contato) {
		if (totalContatos < MAXIMO) {
			contatos[totalContatos] = contato;
			totalContatos++;
		}
	}
	
	/**
	 * Procura por um contato na agenda, privilegiando o nome, quando este
	 * existir, e utilizando o sobrenome caso contrario.
	 * @param needle O nome ou sobrenome do contato.
	 * @return O contato encontrado ou null caso nenhum contato seja
	 * encontrado.
	 */
	public Contato procura(String needle) {
		for (Contato c : contatos) {
			if (c != null) {
				String comparador = c.getSobrenome();
				if (c.getNome() != null) {
					comparador = c.getNome();
				}
				if (comparador.equalsIgnoreCase(needle)) {
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * Exclui um contato da agenda.
	 * @param contato O objeto Contato a ser excluido.
	 */
	public void excluir(Contato contato) {
		for (int i = 0; i < totalContatos; i++) {
			if (contatos[i] == contato) {
				totalContatos--;
				contatos[i] = contatos[totalContatos];
				contatos[totalContatos] = null;
			}
		}
	}


}
