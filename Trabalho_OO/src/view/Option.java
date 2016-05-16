package view;

public class Option {

	private String action;
	private String caption;

	public Option(String caption, String action) {
		this.caption = caption;
		this.action = action;
	}

	public String getCaption() {
		return caption;
	}

	public String getAction() {
		return action;
	}

}
