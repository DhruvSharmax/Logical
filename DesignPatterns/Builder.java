package DesignPatterns;

public class Builder {
	public static void main(String[] args) {
		Student s = Student.Builder.newInstance()
				.setId(1)
				.setName("Dhruv")
				.build();
		
		System.out.println(s.id+" "+s.name);
	}
}

/*
 * So the idea is that we don't create the object by ourself, we get that done from builder pattern,
 * where we can chain our requirements and at the end build method gives me completed object.
 * To achieve that initially only create instance variables and a constructor accepting builder object to initialize variables.
 * 
 * now builder class should be static and an internal class. 
 * All our data creation methods like setters will be in this class only and each one of them will return this object.
 * which will help in chaining.
 * apart from this it should have a static createInstance method which will return new object of builder
 * user is not supposed to create it manually.
 * also it should have a build method which will actually call my root class's constructor with built object as parameter.
 * and return root class object for use.
 */

class Student {
	int id;
	String name;
	
	Student(Builder b) {
		this.id = b.id;
		this.name = b.name;
	}
	
	static class Builder {
		int id;
		String name;
		
		static Builder newInstance() {
			return new Builder();
		}
		
		Builder setId(int id) {
			this.id=id;
			return this;
		}
		
		Builder setName(String name) {
			this.name=name;
			return this;
		}
		
		Student build() {
			return new Student(this);
		}
	}
}
