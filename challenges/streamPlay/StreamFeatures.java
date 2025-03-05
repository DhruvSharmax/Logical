package challenges.streamPlay;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFeatures {

	public static void main(String[] args) {
		String obj = null;

		// handle Null values with optional
		System.out.println(Optional.ofNullable(obj).orElse("deafult"));

		int[] arr = {-3,1,-8,4,-1,2,1,-5,5};

		// using summaryStatistics
		// getMin, getMax, getAverage
		System.out.println(Arrays.stream(arr).boxed().mapToInt(x->x).summaryStatistics().getMax()); // here mapToInt is necessary to get getMin, getMax, getAverage
		Stream.iterate(0,n->n+1).limit(5).forEach(System.out::println);
		Stream.generate(()->"generate").limit(5).forEach(System.out::println);
		Stream.of("of1","of2","of3").forEach(System.out::println);
		List<Employee> list = Arrays.asList(new Employee[] {new Employee(10),new Employee(3),new Employee(5),new Employee(31)});

		// using limit() skip() sorted() and doing reverse sort without reverse() method
		List<Employee> output = list.stream().sorted((o1,o2)->o2.salary()-o1.salary()).collect(Collectors.toList());
		System.out.println(output);
		output = list.stream().limit(3).collect(Collectors.toList());
		System.out.println(output);
		output = list.stream().skip(1).collect(Collectors.toList());
		System.out.println(output);
	}

	// using record of java 17
	public record Employee(int salary) { }
}