package challenges;

import java.util.*;
import java.util.stream.Collectors;
public class MaxEmployeesAttendTraining {
	public static void main(String[] args) {
		System.out.println(countEmp(new String[] {"039","4","14","32","","34","7"})); // "801234567","180234567","0","189234567","891234567","98","9"  // "5421","245","1425","0345","53","354" // "039","4","14","32","","34","7"
	}
	
	/*
	 * Problem statement: https://stackoverflow.com/questions/71988740/find-max-number-of-employees-to-attend-training
	 */
	
	public static int countEmp(String[] input) {
		
		StringBuilder str = new StringBuilder();
		Arrays.stream(input).forEach(x->str.append(x));
		Map<Character, Long> trainingCount = 
				str.chars()
				.mapToObj(x->(char)x)
				.collect(Collectors.groupingBy(x->x,Collectors.counting()));
		trainingCount.entrySet().removeIf(x -> x.getValue() < 2); // because as per problem we want employees to attend training twice

		int employeeCount = 0;
		for (String s : input) {
			for (char training : trainingCount.keySet()) {
				if (s.contains(training+"")) {
					employeeCount++;
					break;
				}
			}
		}
		return employeeCount;
	}
}
