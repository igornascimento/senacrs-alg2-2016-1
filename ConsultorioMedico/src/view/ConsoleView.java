package view;

import com.senac.SimpleJava.Console;

public class ConsoleView {

	public String executeMenu(Menu menu) {
		return menu.execute(this);
	}

	public void displayMessage(String message) {
		Console.println("INFO: ", message);
	}
	
	public void displayUnderline(String message) {
		String underline =
			new String(new char[message.length()]).replace("\0","=");
		Console.print(message,"\n",underline,"\n");
	}

	public void display(String msg) {
		Console.println(msg);
	}

	public void displayError(String message) {
		Console.println("ERROR: ", message);
	}

}
