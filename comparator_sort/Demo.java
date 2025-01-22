package comparator_sort;

import java.util.*;

public class Demo {
	public static void main(String[] args) {
		Employee e1 = new Employee("Rajesh", "Shinde");
		Employee e2 = new Employee("Rajesh", "Kadamb");
		Employee e3 = new Employee("Dhruv", "Sharma");
		
		List<Employee> li = new ArrayList<>();
		li.add(e1);
		li.add(e2);
		li.add(e3);
		
		li.sort(new NameComparator());
		
		System.out.println(li);
		
		Collections.shuffle(li);
		
		li.sort(Comparator.comparing(Employee::getFirstName)
				.thenComparing(Employee::getLastName));
		
		System.out.println(li);
		
		Collections.shuffle(li);
		Comparator<Employee> c = new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		li.sort(c);
		
		//li.stream().sorted(Comparator.comparing(Employee::getFirstName)).
		/*li.sort(new LastNameComparator());
		System.out.println(li);*/
	}
}
