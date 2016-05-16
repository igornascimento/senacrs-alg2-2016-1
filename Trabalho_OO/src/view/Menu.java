package view;

public class Menu {

	private static final int MAX_OPTIONS = 5;
	private String title;
	private Option[] options;
	private int optionCount;
	private ConsoleView view;

	public Menu(String title) {
		this.title = title;
		this.options = new Option[MAX_OPTIONS];
		this.optionCount = 0;
	}

	public void addOption(Option option) {
		if (optionCount < MAX_OPTIONS) {
			options[optionCount] = option;
			optionCount++;
		}
	}

	public void setView(ConsoleView view) {
		this.view = view;
	}

	public String execute() {
		view.display("\n"+this.title);
		view.display(new String(new char[this.title.length()]).replace("\0","-"));
		for (int i = 0; i < optionCount; i++)
			view.display("["+(i+1)+"] "+options[i].getCaption());
		Option o = null;
		while (o == null) {
			int op = view.queryInteger("Opcao:");
			if (op > 0 && op <= optionCount)
				o = options[op-1];
			else
				view.displayError("Opcao invalida.");
		}
		return o.getAction();
	}

}
