package StandardStructures;

public class Singleton {
	public static void main(String[] args) {
		SingleLogic s = SingleLogic.getInstance();
		SingleLogic s1 = SingleLogic.getInstance();
		
		System.out.println(s.hashCode()==s1.hashCode());
	}
	
}

class SingleLogic {
	private static SingleLogic singleton;
	private String s;
	private SingleLogic() {
		s = "hello";
	}
	
	public static SingleLogic getInstance() {
		
		if(singleton==null) {
			synchronized (Singleton.class) {
				if(singleton==null) {
					singleton = new SingleLogic();
				}
			}
		}
		return singleton;
	}
}
