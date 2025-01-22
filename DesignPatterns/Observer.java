package DesignPatterns;

import java.util.*;

public class Observer {
	public static void main(String[] args) {
		Publisher1 p = new Publisher1();
		Subscriber11 s1 = new Subscriber11();
		Subscriber12 s2 = new Subscriber12();
		
		p.addSubscriber(s1);
		p.addSubscriber(s2);
		
		p.broadcast();
		
		p.removeSubscriber(s2);
		
		p.broadcast();
	}
}

class Publisher1 {
	List<Subscriber1> subs;
	String news;
	
	Publisher1(){
		subs = new ArrayList<>();
		news = "dummy news";
	}
	
	public void addSubscriber(Subscriber1 s) {
		subs.add(s);
	}
	
	public void removeSubscriber(Subscriber1 s) {
		subs.remove(s);
	}

	public void broadcast() {
		subs.stream().forEach(x->x.update(news));
	}
}

interface Subscriber1 {
	void update(String news);
}

class Subscriber11 implements Subscriber1{
	String news;
	
	public void update(String news) {
		this.news=news;
		System.out.println("Sending news to Subscriber1");
		System.out.println(news);
	}
}

class Subscriber12 implements Subscriber1{
	String news;
	
	public void update(String news) {
		this.news=news;
		System.out.println("Sending news to Subscriber2");
		System.out.println(news);
	}
}