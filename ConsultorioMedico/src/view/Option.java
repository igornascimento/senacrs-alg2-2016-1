package view;

import patterns.Observable;
import patterns.Observer;

public class Option implements Observable {

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

	/*
	 * Observer implementation.
	 */
	
	private static final int MAX_OBSERVERS = 10;
	private int observerCount = 0;
	private Observer[] observers = new Observer[MAX_OBSERVERS];

	@Override
	public void register(Observer observer) {
		if (observer == null || observerCount >= MAX_OBSERVERS)
			return;
		for (int i = 0; i < observerCount; i++) {
			if (observers[i] == observer)
				return;
		}
		observers[observerCount] = observer;
		observerCount++;
	}

	@Override
	public void unregister(Observer observer) {
		for (int i = 0; i < observerCount; i++) {
			if (observers[i] == observer) {
				observerCount--;
				observers[i] = observers[observerCount];
				observers[observerCount] = null;
			}
		}
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observerCount; i++)
			observers[i].notify(action);
	}

}
