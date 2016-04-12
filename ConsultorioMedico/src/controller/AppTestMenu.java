package controller;

import patterns.Observer;
import view.ConsoleView;
import view.Menu;
import view.Option;

public class AppTestMenu implements Observer {
	
	ConsoleView view = new ConsoleView();

	public void run() {
		String[] menus = { "Pessoas", "Enderecos" };
		
		for (String item : menus) {
			Menu menu = createMenuCadastro(item);
			String action = view.executeMenu(menu);
			view.displayMessage(action);
		}
	}
	

	private Menu createMenuCadastro(String item) {
		String[] options =  {
				"Inserir " + item,
				"Procurar " + item,
				"Excluir " + item
			};
		String lower = item.toLowerCase();
		String[] commands =  {
			lower + ".inserir",
			lower + ".procurar",
			lower + ".excluir"
		};
		return createMenu(item, options, commands);
	}

	private Menu createMenu(String title, String[] options, String[] commands)
	{
		Menu menu = new Menu(title);
		
		for (int i = 0; i < options.length; i++) {
			Option option =
				new Option(options[i], commands[i]);
			option.register(this);
			menu.addOption(option);
		}
		
		return menu;
	}
	
	/*
	 * Observer implementation
	 */

	@Override
	public void notify(String action) {
		view.displayMessage("Action received: " + action);
	}
}
