package StandardStructures;

public final class Immutable {
	private final int data1;
	private final String str;
 private final Student student;
	
		public Immutable(int data1,String str, Student student) {
			this.data1 = data1;
			this.str = str;
   Student temp = new Student();
   temp.setA(1);
   temp.setB(2);
   this.student = temp;  // performed deep copy for mutable object
		}
		
		public int getData1() {
			return data1;
		}
		
		public String getStr() {
			return str;
		}

  public Student getStudent() {
 return student;
}
	}

class Student {
int a;
int b;

public int getA(){
  return a;
}
public int getB(){
  return b;
}

public void setA(int a) {
  this.a=a;
}

public void setB(int b) {
  this.b=b;
}

}
	
