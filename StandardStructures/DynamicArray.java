package StandardStructures;

public class DynamicArray {

	private int[] arr;
	private int count;
	
	public DynamicArray(int i) {
		arr = new int[i];
	}

	public void insert(int item) {
		// if array is full resize it
		if(arr.length==count) {
			int[] newArr = new int[count*2];
		
			// copy old items to new array
			for(int i=0;i<count;i++)
				newArr[i] = arr[i];
			
			arr = newArr;
		}
		//add item at end of array
		arr[count++] = item;

	}
	
	public void print() {
		for(int i=0;i<count;i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args) {
		DynamicArray ar = new DynamicArray(3);
		ar.insert(5);
		ar.insert(6);
		ar.insert(7);
		ar.insert(8);
		ar.print();
	}
}
