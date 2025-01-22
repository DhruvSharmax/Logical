package java23;

import java.util.*;
import java.util.stream.*;

/*
https://belief-driven-design.com/looking-at-java-22-stream-gatherers-9485d/
Gatherers enable a variety of tasks:
1. Grouping elements into batches mid-Stream
2. Custom de-duplication/distinct operations
3. Incremental accumulation or reordering of elements
4. Transform infinite streams into finite ones
 */

public class Gatherers_Demo {
    public static void main(String[] args) {
        List<String> values = Arrays.asList("1", "2", "3");
        // we need output 123
        var result=
                values.stream()
                        .collect(Collectors.joining());
        System.out.println(result);

        // now we want this output to be sent in a List, not just string
        values.stream()
                .gather(Gatherers.fold(()->"", (n1, n2)->n1+n2))     /* notice that gather gave us power to not
                                                            terminate our stream at this point,unlike previous example.*/
                .forEach(System.out::println);          // so we were free to use stream's forEach terminal operation

/*==================================================================================================================*/

        // we want to perform distinct on this list based on the length of elements.
        // without using gather there are 2 ways to do this, having their own issues.

        var list_stream1 = Stream.of("apple", "orange", "banana", "melon", "pineapple");

        // 1st way: here we're using HashSet's distinction power to filter only those elements which are of unique length. (list will start streaming from 0th index so only initial unique words will get passed, discarding remaining uniques).
        // we have nothing to do with set's data here we're just using its return value to filter elements (true if added/false if not)
        // so point is we needed to maintain extra state to be used inside stream, this is not a good stream.
        var state = new HashSet<Integer>();
        list_stream1.filter(x -> state.add(x.length())).forEach(System.out::println);

        // 2nd way: create a class & override its equals hashcode to store these elements there and make them unique w.r.t length of string

        record DistinctionByLength(String str){
            @Override
            public boolean equals(Object o) {
                return o instanceof DistinctionByLength(String str)
                        && this.str.length()==str.length();
            }

            @Override
            public int hashCode() {
                return str == null ? 0 : Integer.hashCode(str.length());
            }
        }

        // creating another stream coz previous stream was closed, why we cant re-use same data ? coz that's the nature of stream, its not a data storage, it just works in memory and goes away.
        var list_stream2 = Stream.of("apple", "orange", "banana", "melon", "pineapple");
        list_stream2.map(DistinctionByLength::new)      //adding strings in our custom class
                .distinct()
                .map(DistinctionByLength::str)      //getting back strings after distinct filtered them
                .forEach(System.out::println);

/*
in both above ways we had to rely on some another resource or some another code to work,
or making things complicated with extra code. Gather gives us flexibility to use collect kind of operation(terminal op)
like its a map operation (intermediate op).
 */
        var list_stream3 = Stream.of("apple", "orange", "banana", "melon", "pineapple");
        list_stream3.gather(Gatherer.ofSequential
                (
                        HashSet::new,                       // here we're still creating a state but its inside stream only
                        (state1, element, downstream) -> {
                            if (state1.add(element.length()))   // similar to line 46 we're using hashSet's boolean return on adding unique length element
                                return downstream.push(element);
                            else
                                return downstream.isRejecting();
                        },
                        Gatherer.defaultFinisher()
                )
        ).forEach(System.out::println);
    }
}
