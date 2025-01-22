package StandardStructures;
public class SingletonEnum {
	public static void main(String[] args) {
		System.out.println(SingletonDemo.INSTANCE.getInstance() == SingletonDemo.INSTANCE.getInstance());
	}
	
	private enum SingletonDemo {
		INSTANCE;
		
		public  SingletonDemo getInstance() {
			return INSTANCE;
		}
	}
}
