package controller;

import app.RealStateApplication;
import model.Pessoa;
import view.ConsoleView;
import view.Menu;
import view.Option;

public class PessoaView {
	
	private ConsoleView view;
	private Menu menu;
	private RealStateApplication app;

	public PessoaView(ConsoleView view, RealStateApplication app) {
		this.app = app;
		this.view = view;
		this.menu = new Menu("Cadastro de Pessoas");
		this.menu.addOption(new Option("Incluir Pessoa","add.pessoa"));
		this.menu.addOption(new Option("Excluir Pessoa","del.pessoa"));
		this.menu.addOption(new Option("Exibir Pessoa","lst.pessoa"));
		this.menu.addOption(new Option("Voltar","back"));
	}

	public void execute() {
		while (true) {
			switch (view.execute(menu)) {
				case "add.pessoa": incluiPessoa(); break;
				case "del.pessoa": excluirPessoa(); break;
				case "lst.pessoa": listarPessoa(); break;
				default: return;
			}
		}
	}

	private void listarPessoa() {
		Pessoa p = app.pesquisaPessoa(view.queryString("Nome da pessoa:"));
		if (p != null)
			displayPessoa(p);
	}

	private void displayPessoa(Pessoa p) {
		view.display("Nome: " + p.getNomeCompleto());
		view.display("Nascimento: " +p.getDataNascimento("dd-MM-yyyy"));
		view.display("Idade: " + p.getIdade());
	}

	private void excluirPessoa() {
		app.excluiPessoa(view.queryString("Nome a excluir:"));
	}

	private void incluiPessoa() {
		view.display("Incluindo Pessoa");
		Pessoa pessoa = criaPessoa();
		app.incluiPessoa(pessoa);
	}

	private Pessoa criaPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(view.queryString("Nome:"));
		pessoa.setSobrenome(view.queryString("Sobrenome:"));
		pessoa.setDataNascimento(view.queryString("Data de Nascimento:"));
		return pessoa;
	}

}
