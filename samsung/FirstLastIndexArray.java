package samsung;

public class FirstLastIndexArray {
	public static void main(String[] args) {
		byte[] b = { 'A', 'A', 'B', 'B', 'C', 'C' };

		byte element = 'B'; // inputs

		getFirstLastIndex(b, element);
	}

	public static void getFirstLastIndex(byte[] b, byte element) {
		int firstElementIndex = -1, lastElementIndex = -1;

		for (int i = 0; i < b.length; i++) {
			if (b[i] == element) {
				if (firstElementIndex == -1) {
					firstElementIndex = i;
				}
				lastElementIndex = i;
			}
		}
		System.out.println("first is at:" + firstElementIndex + " last is at: " + lastElementIndex);
	}
}

// select * from Employee1 e1 left outer join Employee2 e2 on e1.id!=e2.id;

// select name,empid from Employee where empid=(select managerid from Employee)
// group by name,empid;
