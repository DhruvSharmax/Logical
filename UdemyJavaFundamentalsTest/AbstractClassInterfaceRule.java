package UdemyJavaFundamentalsTest;

interface Payment {
    default String type(){
        return "none";
    }
}

abstract class RewardsPoints {
    abstract String type();
}

public class AbstractClassInterfaceRule extends RewardsPoints implements Payment {
    public AbstractClassInterfaceRule(){
        super();
    }
    public String type(){
        return "points";
    }

    public static void main(String[] args) {
        System.out.println(((RewardsPoints)new AbstractClassInterfaceRule()).type());
    }
}
