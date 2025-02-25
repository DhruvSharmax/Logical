package challenges;

public class StaticPlay {
    public static void main(String[] args) {
        System.out.println(Child.name+Child.name1);
    }
}

class Parent {
    static String name = "Parent";
    static {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    static  String name1="Child1";
    static {
        System.out.println("Child");
    }
}
