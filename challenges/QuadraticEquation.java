package challenges;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
        double x1=0.0,x2=0.0;
        double middle_value = Math.sqrt((b*b)-4*a*c);
        
        x1 = (-b + middle_value)/(2*a);
        x2 = (-b - middle_value)/(2*a);
        
        Roots r = new Roots(x1,x2);
        return r;
    }
    
    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {         
        this.x1 = x1;
        this.x2 = x2;
    }
}