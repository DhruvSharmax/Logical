import java.util.*;
import java.util.stream.Collectors;

import static java.io.IO.readln;

void main() {
    String str = readln("Please enter comma separated integer values:");
    var newlist = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    Collections.reverse(newlist);
    System.out.println("Output is: " + newlist);
}
