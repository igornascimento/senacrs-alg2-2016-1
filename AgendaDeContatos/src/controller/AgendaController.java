package controller;

import model.Agenda;
import model.Contato;
import view.ContatoView;
import view.Menu;

/**
 * A classe AgendaController e o controlador da agenda
 * de contatos, fazendo a ligacao entre o modelo de dados
 * (model) e a interface com o usuario (view)
 */
public class AgendaController {
	private Menu menu = new Menu();
	private ContatoView contatoView = new ContatoView();
	private Agenda agenda = new Agenda();
	
	/**
	 * Metodo inicial da aplicacao
	 */
	public void run() {
		boolean executar = true;
		while (executar) {
			menu.exibir();
			switch (menu.getOpcao()) {
				case 1: inserirContato(); break;
				case 2: exibirContato(); break;
				case 3: excluirContato(); break;
				case 4: executar = false; break;
			}
		}
	}

	/**
	 * Pergunta ao usuario pelo nome do cotnato a ser procurado e
	 * faz a requisicao do contato a Agenda. Retorna o contato
	 * encontrado ou "null" quando nenhum contato for encontrado.
	 * @return O contato encontrado ou null caso nenhum contato
	 * seja encontrado.
	 */
	private Contato procurarContato() {
		String needle = contatoView.questionaUsuario("Nome");
		return agenda.procura(needle);
	}
	
	/**
	 * Pergunta ao usuario pelo nome de um cotato e imprime seus
	 * dados caso um Contato com esse nome seja encontrado.
	 */
	private void exibirContato() {
		contatoView.mensagem("Exibir Contato");
		Contato contato = procurarContato();
		if (contato != null) {
			contatoView.exibeContato(contato);
		} else {
			contatoView.exibeErro("Contato nao encontrado.");
		}
	}

	/**
	 * Requisita a "view" a criacao de um novo contato, e o
	 * reassa a Agenda. Num MVC "correto", apenas os dados
	 * do cotato seriam requisitados a "view", e o Contato
	 * seria criado no "Controller", porem, devido as limitacoes
	 * ainda existentes na aplicacao e na utilizacao do Console,
	 * a criacao do objeto esta sendo feita pela "view" e nao
	 * no "controller"
	 */
	private void inserirContato() {
		contatoView.mensagem("Inserir Contato");
		Contato contato = contatoView.leContato();
		agenda.adiciona(contato);
	}

	/**
	 * Pergunta ao usuario pelo nome de um contato, caso
	 * o contato exista na agenda, requistia ao usuario para
	 * confirmar a exclusao, e em caso positivo, requer a
	 * agenda que o contato seja excluido.
	 */
	private void excluirContato() {
		contatoView.mensagem("Excluir Contato");
		Contato contato = procurarContato();
		if (contato != null) {
			contatoView.exibeResumoContato(contato);
			if (contatoView.confirma("Excluir contato?")) {
				agenda.excluir(contato);
			} else {
				contatoView.mensagem("Nenhum contato excluido.");
			}
		} else {
			contatoView.exibeErro("Contato nao encontrado.");
		}
	}
}
