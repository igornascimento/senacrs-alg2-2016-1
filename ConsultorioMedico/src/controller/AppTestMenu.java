package controller;

import view.ConsoleView;
import view.Menu;
import view.Option;

public class AppTestMenu {
	public void run() {
		ConsoleView view = new ConsoleView();

		Menu menuPessoa = createMenuPessoa();
		String action = view.executeMenu(menuPessoa);
		view.displayMessage(action);

		Menu menuMedicamento = createMenuMedicamento();
		action = view.executeMenu(menuMedicamento);
		view.displayMessage(action);
	}
	
	private Menu createMenuMedicamento() {
		String[] options =  {
				"Inserir Medicamento",
				"Procurar Medicamento",
				"Excluir Medicamento"
			};
			String[] commands =  {
				"medicamento.inserir",
				"medicamento.procurar",
				"medicamento.excluir"
			};
		return createMenu("Medicamentos",options, commands);
	}

	private Menu createMenuPessoa() {
		String[] options =  {
			"Inserir Pessoa",
			"Procurar Pessoa",
			"Excluir Pessoa"
		};
		String[] commands =  {
			"pessoa.inserir",
			"pessoa.procurar",
			"pessoa.excluir"
		};
		return createMenu("Pessoas", options, commands);
	}

	private Menu createMenu(String title, String[] options, String[] commands)
	{
		Menu menu = new Menu(title);
		
		for (int i = 0; i < options.length; i++) {
			Option option =
				new Option(options[i], commands[i]);
			menu.addOption(option);
		}
		
		return menu;
	}
}
