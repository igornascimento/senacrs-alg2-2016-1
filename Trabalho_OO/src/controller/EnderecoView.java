package controller;

import app.RealStateApplication;
import view.ConsoleView;

public class EnderecoView {

	private ConsoleView view;
	private RealStateApplication app;

	public EnderecoView(ConsoleView view, RealStateApplication app) {
		this.app = app;
		this.view = view;
	}

	public void execute() {
		view.displayError("Esta parte fica como exercicio!");
	}

}
