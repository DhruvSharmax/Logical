package StandardPatterns;


public class MyLinkedList {
	Node head;
	
	public class Node {
		int data;
		Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public void removeByIndex(int index) {
		
		if(index==0) {
			head=head.next;
			return;
		}
		
		Node temp = head;
		
		for(int i=0;i<index-1 && temp.next!=null; i++ ) {
			temp = temp.next;
		}
		
		if(temp==null || temp.next==null) {
			System.out.println("index not there");
			return;
		}
		
		temp.next = temp.next.next;
	}
	
	public Node reverseList(Node head) {
		Node curr,prev,next;
		curr=head;
		prev=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
	
	private void addFirst(int i) {
		head=new Node(i,head);
	}
	
	private void addLast(int i) {
		Node temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next = new Node(i,null);
	}
	
	public void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList li = new MyLinkedList();
		
		li.addFirst(2);
		li.addFirst(3);
		li.addFirst(6);
		li.addFirst(10);
		li.addFirst(16);
		
		li.printList();
		
		System.out.println("------------");
		
		li.removeByIndex(1);
		
		li.printList();
		
		System.out.println("------------");
		
		li.head = li.reverseList(li.head);
		
		li.printList();
		
		System.out.println("------------");
		
		li.addFirst(15);
		
		li.printList();
		
		System.out.println("------------");
		
		li.addLast(1);
		
		li.printList();
		
		System.out.println("------------");
		
		li.removeNthFromLast(2);
		
		li.printList();
		
		System.out.println("------------");
	}

	private void removeNthFromLast(int n) {
		Node temp = head;
		int len = 1;
		
		while(temp.next!=null) {
			temp=temp.next;
			len++;
		}
		
		if(len==n) {
			head=head.next;
			return;
		}
		
		if(len<n) return;
		int index = len-n;
		
		// you got index from start so now you get run normal remove from nth node logic
		// given in removeByIndex(int index) method
		
		temp = head;
		
		for(int i=0;i<index-1 && temp.next!=null;i++)
			temp=temp.next;
		
		if(temp==null||temp.next==null) return;
		
		temp.next=temp.next.next;
	}
}