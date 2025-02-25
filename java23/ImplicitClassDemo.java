import java.util.*;
import java.util.stream.Collectors;

import static java.io.IO.readln;

void main(String[] args) {
    String str = readln("Please enter comma separated List values:");
    var newlist = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    System.out.println("Input was: " + newlist);
    Collections.reverse(newlist);
    System.out.println("Output is: " + newlist);
}
