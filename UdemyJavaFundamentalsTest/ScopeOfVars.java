package UdemyJavaFundamentalsTest;

public class ScopeOfVars {
    static String description = "Activity from";
    boolean available = true;
    protected String bookingLink = "";
    private static String type = "Activity";

    public void bookActivity(){
        String prefix = "AC-";
        description="g";
        available=false;
        bookingLink="g";
        type="h";
    }
}
