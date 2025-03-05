import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

void main(){
    Employee e = new Employee(1, "A", 10000);
    List<Employee> list = new ArrayList<>();
    List<Employee> immutableList = Collections.unmodifiableList(list);

        list.add(e);
        System.out.println(list);
    try {
        immutableList.add(e);
    } catch (UnsupportedOperationException _) {
        System.out.println("immutable list cannot be updated");
    }
}
record Employee(int id, String name, long salary){}
