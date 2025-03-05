package JavaSpecific.UdemyJavaFundamentalsTest;

public class WhichObjectModifies {
    private String email;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void modifyEmail(WhichObjectModifies user, String email) {
        user = new WhichObjectModifies();
        user.setEmail(email);
    }

    public static void main(String[] args) {
        WhichObjectModifies u1 = new WhichObjectModifies();
        u1.setEmail("xyz123");
        WhichObjectModifies u2 = new WhichObjectModifies();
        u2.setEmail("user123");
        modifyEmail(u2, "abc123");
        System.out.println(u1.getEmail());
        System.out.println(u2.getEmail());
    }
}
