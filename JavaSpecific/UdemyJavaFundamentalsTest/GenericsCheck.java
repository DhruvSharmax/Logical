package JavaSpecific.UdemyJavaFundamentalsTest;

import java.util.*;

public class GenericsCheck {
    private static <A extends Collection <B>, B> B
    add(A list, B element) {
        list.add(element);
        return element;
    }

    public static void main(String[] args) {
        List<String> hosts = new ArrayList<>();
        add(hosts, "London");
        add(hosts, "Athes");
        add(hosts, "London");
        System.out.println(hosts);
    }
}



