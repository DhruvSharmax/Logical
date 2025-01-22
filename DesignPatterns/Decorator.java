package DesignPatterns;

public class Decorator {
	public static void main(String[] args) {
		Pizza p = new MargharitaPizza();
		System.out.println("your pizza is: "+ p.getDescription()+" and cost is: "+p.getCost());
		
		p = new DecoratePaneer(p);
		p = new DecorateJalapeno(p);
		
		System.out.println("your pizza is: "+ p.getDescription()+" and cost is: "+p.getCost());
	}
}
/*
 * this pattern provides flexibility to add/remove decorated objects at runtime.
 * to achieve that, first we create a interface having basic functions and/or variables.
 * than we implement this in a class, now the requirement is that we should be able to decorate this class with different requirements
 * so we implement Decorator class from same interface and it can be any number of decorator classes.
 * in decorator we create a reference of our interface and initialize it in parameterized constructor.
 * Now this particular step has given me access to all those classes which will be passed in this constructor.
 * I can modify it as required and return same interface object because Decorator is also implementing root interface.
 */
interface Pizza {
	public String getDescription();
	public abstract int getCost();
}

class MargharitaPizza implements Pizza {
	@Override
	public int getCost() {
		return 100;
	}

	@Override
	public String getDescription() {
		return "Margharita";
	}
}

class DecoratePaneer implements Pizza {
	
	Pizza p;
	
	DecoratePaneer(Pizza p){
		this.p = p;
	}
	
	@Override
	public int getCost() {
		return 20+p.getCost();
	}

	@Override
	public String getDescription() {
		return p.getDescription()+" with paneer";
	}
}

class DecorateJalapeno implements Pizza {
	
	Pizza p;
	
	DecorateJalapeno(Pizza p){
		this.p = p;
	}
	
	@Override
	public int getCost() {
		return 20+p.getCost();
	}

	@Override
	public String getDescription() {
		return p.getDescription()+" with jalapeno";
	}
}