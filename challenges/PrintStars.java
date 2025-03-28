package challenges;

public class PrintStars {
    public static void main(String[] args) {
        myStar(6);
        myStar(4);
    }

    private static void myStar(int n) {
        printStar(n);
        for(int i=0;i<n-2;i++)
            printSpacedStar(n);
        printStar(n);
    }

   static void printStar(int n){
        for (int i=0; i<n;i++)
            System.out.print("*");

       System.out.println("\n");
    }

    static void printSpacedStar(int n) {
        System.out.print("*");
        for (int i = 0; i < n - 2; i++)
            System.out.print(" ");
        System.out.print("*");

        System.out.println("\n");
    }
}
