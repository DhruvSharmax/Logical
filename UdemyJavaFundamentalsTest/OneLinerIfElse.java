package UdemyJavaFundamentalsTest;

public class OneLinerIfElse {
    public static void main(String[] args) {
        long num1 = 4, num2 = 3, num3 = 8;
        long result = num1++ < num2 ? (num1 > --num3) ? num1++/num2
                : --num1/num2 : num3++/num2;
        System.out.println(result++);
    }
}
