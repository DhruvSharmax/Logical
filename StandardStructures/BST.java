package StandardStructures;
public class BST {
	Node root;
	static int counter = 0;
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
		
		bst.print();	// in order traversal or in ascending order
		
		bst.search(1);
		
		System.out.println(bst.getNthNode(3));		// in ascending order
	}

	private void insert(int data) {
		root = insertElement(data,root);
	}

	private Node insertElement(int data, Node root) {
		if(root==null)
			return new Node(data,null,null);
		
		if(data<root.data)
			root.left = insertElement(data,root.left);
		else
			root.right = insertElement(data,root.right);
		
		return root;
	}
	
	private void print() {
		printElement(root);
	}

	/* inOrder traversal, basically low to high
	 * left root right
	 */
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
			System.out.printf("found %d in tree\n",data);
		else
			System.out.printf("%d is not there\n",data);
	}

	private Node searchElement(Node root, int data) {
		if(root==null || root.data==data)
			return root;
		if(root.data>data)
			return searchElement(root.left, data);
		return searchElement(root.right, data);
	}
	
	public int getNthNode(int n) {
		Node out = getNthNodeData(root,n);
		if(out==null) return 0;
		
		return out.data;
	}

	/* inOrder traversal, basically low to high
	 * left root right
	 */
	private Node getNthNodeData(Node root, int n) {		
		if(root==null) return root;
		Node left = getNthNodeData(root.left,n);
		
		if(left!=null)
			return left;
		counter++;
		if(counter==n) return root;
		
		return getNthNodeData(root.right,n);
	}
}