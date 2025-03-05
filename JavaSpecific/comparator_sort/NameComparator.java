package JavaSpecific.comparator_sort;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getFirstName().compareTo(e2.getFirstName())==0){
			if(e1.getLastName().compareTo(e2.getLastName())==0) {
				return 0;
			}
			else if(e1.getFirstName().compareTo(e2.getFirstName())==1) {
				if(e1.getLastName().compareTo(e2.getLastName())==1) {
					return 1;
				}
			}
		}
		return -1;
	}
	
}
