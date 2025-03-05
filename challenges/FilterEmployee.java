import java.util.function.Predicate;
import java.util.stream.Stream;

void main(String[] args) {
    Predicate<Employee> p1 = x-> x.salary()>40000;
    Predicate<Employee> p2 = x-> x.salary()<60000;
    Predicate<Employee> p3 = p1.and(p2);
        Stream.of(new Employee("A",40000), new Employee("B",50000),new Employee("C",60000), new Employee("D", 10000))
                .filter(p3).forEach(System.out::println);
}
record Employee(String name, long salary){}