package UdemyJavaFundamentalsTest;

class Message<T>{
    private T messageText;
    void setMessage(T t) {
        messageText = t;
        System.out.println("Message: setMessage");
    }
}

class ErrorMessage<S extends CharSequence> extends Message <String> {
    public ErrorMessage(S s) {}
    void setMessage(S s) {
        System.out.println("ErrorMessage: setMessage");
    }
}

public class InheritenceWithGenrics {
    public static void main(String[] args) {
        ErrorMessage <String> err = new ErrorMessage<String>("Error");
        err.setMessage("Webservice error");     // because there are two inherited methods with String param
    }
}
