package JavaSpecific.UdemyJavaFundamentalsTest;

import javax.naming.InvalidNameException;
import javax.naming.NamingException;

public class NotAboutExceptionHierarchy {
    public void bind(){
        try{
            throw new NamingException("Naming failure");
        } catch (Exception e) {
            try {
                throw new InvalidNameException("Empty name not allowed");
            } catch (NamingException e) {   // exception coz two same name exception variable cant be in one scope
                System.out.print("Bind failed");
            }
        }
    }

    public static void main(String[] args) {
        new NotAboutExceptionHierarchy().bind();
    }
}
