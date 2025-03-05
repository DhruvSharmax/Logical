package DesignPatterns;

public class SingletonPlain {
	private static SingletonPlain obj;
	
	private SingletonPlain() {
	}
	
	public static SingletonPlain getInstance() {
		if(obj==null){
			obj = new SingletonPlain();
		}
		return obj;
	}
	
	public static void main(String[] args) {
		System.out.println(SingletonPlain.getInstance()==SingletonPlain.getInstance());
	}
}
