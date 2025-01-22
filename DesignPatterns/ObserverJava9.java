package DesignPatterns;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ObserverJava9 {
	public static void main(String[] args) {
		Publisher p = new Publisher();
		Subscriber s = new Subscriber();
		
		p.addPropertyChangeListener(s);
		p.setNews("Dhruv");
		System.out.println(s.getNews());
	}
}

class Publisher {
	String news;
	PropertyChangeSupport support;
	
	Publisher(){
		support = new PropertyChangeSupport(this);
	}
	
	void setNews(String value) {
		support.firePropertyChange("news", this.news, value);
		this.news = value;
	}
	
	void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}
	
	void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
}

class Subscriber implements PropertyChangeListener {
	String news;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.setNews((String)evt.getNewValue());
	}
	
	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}
}