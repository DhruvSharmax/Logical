package DynamicArray;

public class Array {

	private int[] arr;
	private int count;
	
	public Array(int i) {
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

}