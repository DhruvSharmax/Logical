package StandardStructures;

public final class Immutable {
	private final int data1;
	private final String str;
	
		public Immutable(int data1,String str) {
			this.data1 = data1;
			this.str = str;
		}
		
		public int getData1() {
			return data1;
		}
		
		public String getStr() {
			return str;
		}
	}
	
