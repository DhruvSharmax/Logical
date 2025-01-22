package UdemyJavaFundamentalsTest;

public class DoubleCheck {
    public static void main(String[] args) {
        String numText = "12.35d"; // This will cause a NumberFormatException
        double number = Double.parseDouble(numText);
        System.out.println(number);
    }
}

