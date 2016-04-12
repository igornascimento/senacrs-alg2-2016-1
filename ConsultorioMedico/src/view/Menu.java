package view;

import com.senac.SimpleJava.Console;

public class Menu {

	private static final int MAX_OPTIONS = 10;

	
	private String title;
	private int optionCount;
	private Option[] options;

	public Menu(String title) {
		this.title = title;
		this.optionCount = 0;
		options = new Option[MAX_OPTIONS];
	}

	public String execute(ConsoleView view) {
		view.display("");
		view.displayUnderline(title);
		for (int i = 0; i < optionCount; i++)
			view.display("[" + (i+1) + "] " + options[i].getText());
		view.display("");
		
		Option choice = null;
		while (choice == null) {
			int c = Console.readInt("Opcao: ");
			if (c < 1 || c > optionCount) {
				view.displayError("Opcao invalida.");
			} else {
				choice = options[c-1];
			}
		}
		choice.notifyObservers();
		return choice.getAction();
	}

	public void addOption(Option option) {
		if (optionCount < MAX_OPTIONS) {
			options[optionCount] = option;
			optionCount++;
		}
	}
}
