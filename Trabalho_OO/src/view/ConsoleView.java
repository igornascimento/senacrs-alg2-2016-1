package view;

import com.senac.SimpleJava.Console;

public class ConsoleView {

	public String execute(Menu menu) {
		menu.setView(this);
		return menu.execute();
	}

	public void display(String msg) {
		Console.println(msg);
	}

	public void displayError(String msg) {
		Console.println("ERROR:", msg);
	}

	public int queryInteger(String prompt) {
		return Console.readInt(prompt);
	}

	public String queryString(String prompt) {
		return Console.readString(prompt);
	}

}
