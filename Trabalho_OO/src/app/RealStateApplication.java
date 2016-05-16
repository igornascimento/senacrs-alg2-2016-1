package app;

import controller.EnderecoView;
import controller.PessoaView;
import model.ListaPessoas;
import model.Pessoa;
import view.ConsoleView;
import view.Menu;
import view.Option;

public class RealStateApplication {
	
	private ListaPessoas listaPessoas;

	public void run() {
		listaPessoas = new ListaPessoas();
		
		Menu menu = new Menu("Real State");
		menu.addOption(new Option("Cadastro Pessoas","cad.pessoas"));
		menu.addOption(new Option("Cadastro Enderecos","cad.end"));
		menu.addOption(new Option("Sair","back"));
		
		ConsoleView view = new ConsoleView();
		PessoaView pessoaView = new PessoaView(view, this);
		EnderecoView enderecoView = new EnderecoView(view, this);
		while (true) {
			switch (view.execute(menu)) {
				case "cad.pessoas":
					pessoaView.execute();
					break;
				case "cad.end":
					enderecoView.execute();
					break;
				default: return;
			}
		}
	}

	public void incluiPessoa(Pessoa pessoa) {
		listaPessoas.incluiPessoa(pessoa);
	}

	public void excluiPessoa(String nome) {
		listaPessoas.excluiPessoa(nome);
	}

	public Pessoa pesquisaPessoa(String nome) {
		return listaPessoas.pesquisaPessoa(nome);
	}
}
