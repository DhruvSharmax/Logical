package StandardStructures;

import java.util.Random;

public class MyLinkedList {
	Node head;
	
	public static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList li = new MyLinkedList();
		Random rand = new Random();
		
		System.out.println("----Creating a list----");
		for(int i=0;i<6;i++)
			li.addFirst(rand.nextInt(10));
			
		li.printList();
		
		System.out.println("----Remove element by index----");
		li.removeByIndex(1);
		
		li.printList();
		
		System.out.println("----Reverse the List----");
		li.head = li.reverseList(li.head);
		
		li.printList();
		
		System.out.println("----Add element at start----");
		li.addFirst(15);
		
		li.printList();
		
		System.out.println("----Add element at last----");
		li.addLast(1);
		
		li.printList();
		
		System.out.println("----Remove n'th element from last----");
		li.removeNthFromLast(2);
		
		li.printList();
		
		// Add two numbers in reversed LinkedList, for this you need to make sure you only add single digit numbers
		System.out.println("----Randomly Creating two new Lists----");
		MyLinkedList li1 = new MyLinkedList();
		for(int i=0;i<3;i++)
			li1.addFirst(rand.nextInt(9));
		
		MyLinkedList li2 = new MyLinkedList();
		for(int i=0;i<3;i++)
			li2.addFirst(rand.nextInt(9));
		
		li1.printList();
		li2.printList();
		
		System.out.println("----Sum of above two new Lists----");
		Node result = addTwoNumbers(li1.head, li2.head);
		li1.head = result;
		li1.printList();
		
		System.out.println("----Creating two new ed Lists----");
		li1 = new MyLinkedList();
		li2 = new MyLinkedList();
		li1.addLast(5);li1.addLast(10);li1.addLast(15);
		li2.addLast(2);li2.addLast(10);li2.addLast(20);
		li1.printList();
		li2.printList();
		
		System.out.println("----Merge of above two sorted arrays----");
		result = mergeSortedList(li1.head,li2.head);
		li1.head = result;
		li1.printList();
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
		Node temp = head;
		head=new Node(i);
		head.next=temp;
	}
	
	private void addLast(int i) {
		if(head==null) {
			head = new Node(i);
			return;
		}
		Node temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next = new Node(i);
	}
	
	public void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("\n");
	}

	private void removeNthFromLast(int n) {
		
		// getting length of list
		
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
		
		temp = head;
		
		for(int i=0;i<index-1 && temp.next!=null;i++)
			temp=temp.next;
		
		if(temp==null||temp.next==null) return;
		
		temp.next=temp.next.next;
	}
	
	// Add 2 numbers in reversedLinkedList
	 public static Node addTwoNumbers(Node l1, Node l2) {
	       Node sumList = new Node(0);
	        Node traverseList = sumList;
	        int carry = 0;
	        while(l1!=null||l2!=null) {
	            int a = l1!=null?l1.data:0;
	            int b = l2!=null?l2.data:0;
	            
	            int sum = a+b+carry;
	            carry = sum/10;
	            
	            traverseList.next = new Node(sum%10);
	            traverseList = traverseList.next;
				
				if(l1!=null) l1=l1.next;
	            if(l2!=null) l2=l2.next;
	        }
	        
	        if(carry>0)
	            traverseList.next = new Node(carry);
	        
	        return sumList.next;
	    }
	 
	 private static Node mergeSortedList(Node list1, Node list2) {
			Node result = new Node(0);
			Node traverse = result;
			while(true) {
				if(list1==null) {
					traverse.next = list2;
					break;
				}
				if(list2==null) {
					traverse.next = list1;
					break;
				}
				if(list1.data<list2.data) {
					traverse.next = list1;
					list1 = list1.next;
				} else {
					traverse.next = list2;
					list2 = list2.next;
				}
				traverse = traverse.next;
			}
			return result.next;
		}
}