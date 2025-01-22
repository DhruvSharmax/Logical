package StandardPatterns;
public class BST {
	Node root;
	class Node {
		int data;
		Node right,left;
		
		public Node(int data, Node right, Node left) {
			this.data = data;
			this.right = right;
			this.left = left;
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(10);
		bst.insert(1);
		bst.insert(15);
		bst.insert(20);
		bst.insert(3);
		
		bst.print();
		
		bst.search(1);
	}

	private void insert(int data) {
		root = insertElement(root,data);
	}

	private Node insertElement(Node root, int data) {
		if(root==null)
			return new Node(data,null,null);
		
		if(root.data>data)
			root.left = insertElement(root.left, data);
		else
			root.right = insertElement(root.right, data);
		
		return root;
	}
	
	private void print() {
		printElement(root);
	}

	private void printElement(Node root) {
		if(root!=null) {
			printElement(root.left);
			System.out.println(root.data);
			printElement(root.right);
		}
	}
	
	private void search(int data) {
		Node out = searchElement(root,data);
		if(out!=null)
			System.out.printf("found %d in tree",data);
		else
			System.out.printf("%d is not there",data);
	}

	private Node searchElement(Node root, int data) {
		if(root==null || root.data==data)
			return root;
		if(root.data>data)
			return searchElement(root.left, data);
		return searchElement(root.right, data);
	}
}