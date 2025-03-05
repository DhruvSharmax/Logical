package JavaSpecific.UdemyJavaFundamentalsTest;

import java.util.Optional;

public class EmptyOptional {
    public static void main(String[] args) {
        scheduleEvent(Optional.empty());
    }

    private static void scheduleEvent(Optional<String> event) {
        System.out.println(event.orElse("sample"));
    }
}
