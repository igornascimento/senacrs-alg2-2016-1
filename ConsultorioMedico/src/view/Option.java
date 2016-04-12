package view;

public class Option {

	private String text;
	private String action;

	public Option(String text, String action) {
		this.text = text;
		this.action = action;
	}

	public String getText() {
		return text;
	}

	public String getAction() {
		return action;
	}

}
