package JavaSpecific;

import java.util.*;

public class Employee_HashCode_Equals {

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", salary=" + salary + "]";
	}

	String name;
	Integer empId;
	Integer salary;

	public Employee_HashCode_Equals(String name, Integer empId, Integer salary) {
		super();
		this.name = name;
		this.empId = empId;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public static void main(String[] args) {
		Employee_HashCode_Equals emp1 = new Employee_HashCode_Equals("Rohit", 10, 100);
		Employee_HashCode_Equals emp2 = new Employee_HashCode_Equals("Rahul", 20, 100);
		Employee_HashCode_Equals emp3 = new Employee_HashCode_Equals("Rahul", 30, 50);
		Employee_HashCode_Equals emp4 = new Employee_HashCode_Equals("Rohit", 10, 100);
		List<Employee_HashCode_Equals> empList = Arrays.asList(emp1, emp2, emp3, emp4);
		System.out.println(empList);
		Set<Employee_HashCode_Equals> empSet = new HashSet<>(empList);
		System.out.println(empSet);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee_HashCode_Equals other = (Employee_HashCode_Equals) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
}
