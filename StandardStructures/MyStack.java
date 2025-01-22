package StandardStructures;

public class MyStack {
	Node top;
	int length = 0;
	
	class Node {
		int data;
		Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public void push(int data) {
		top = new Node(data, top);
		length++;
	}
	
	public int pop() {
		if(length==0) {
			System.out.println("Stack Empty");
			return -1;
		}
		int popData = top.data;
		top = top.next;
		length--;
		return popData;
	}
	
	public int peek() {
		if(length==0) {
			System.out.println("Stack Empty");
			return -1;
		}
		return top.data;
	}
	
	public int getLength() {
		return length;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(10);
		stack.push(1);
		stack.push(5);
		stack.push(7);
		
		System.out.println(stack.peek() + "Length is:"+stack.getLength());
		
		System.out.println(stack.pop() + "Length is:"+stack.getLength());
		
		System.out.println(stack.pop() + "Length is:"+stack.getLength());
		System.out.println(stack.pop() + "Length is:"+stack.getLength());
		System.out.println(stack.pop() + "Length is:"+stack.getLength());
		System.out.println(stack.pop() + "Length is:"+stack.getLength());
		System.out.println(stack.pop() + "Length is:"+stack.getLength());
		
		
	}
}
