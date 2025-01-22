package challenges;

/*
 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 */
public class DiameterOfBinaryTree {
	
	public static int maxDiameter = 0;;
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.left = new Node(2);
		n1.right = new Node(3);
		n1.right.right = new Node(4);
		n1.right.right.right = new Node(5);
		n1.right.right.right.right = new Node(6);
		n1.left = new Node(6);
		n1.left.left = new Node(7);
		n1.left.left.left = new Node(8);
		calculateDiameter(n1);
		System.out.println(maxDiameter);
	}

	private static int calculateDiameter(Node root) {
		if(root==null) 
			return 0;
		
		int leftMax = calculateDiameter(root.left);
		int rightMax = calculateDiameter(root.right);
		
		maxDiameter = Math.max(maxDiameter, rightMax+leftMax);
		
		return 1 +Math.max(leftMax, rightMax);
	}
}

class Node {
	int data;
	Node right;
	Node left;
	
	Node(int data){
		this.data=data;
		left = null;
		right = null;
	}
}
