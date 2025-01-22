package DynamicProgramming;
/*
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 */
public class BSTMaximumPathSum {
	
	static int result;
	
	public static void main(String args[]) {
        Node n1 = new Node(10);
        n1.left = new Node(2);
        n1.right = new Node(10);
        n1.left.left = new Node(20);
        n1.left.right = new Node(1);
        n1.right.right = new Node(-25);
        n1.right.right.left = new Node(3);
        n1.right.right.right = new Node(4);
        findMaxSum(n1);
        System.out.println("maximum path sum is : " + result);
    }

	static int findMaxSum(Node root) {
		if(root==null) return 0;
		
		int r = findMaxSum(root.right);
		int l = findMaxSum(root.left);
		
		int currData = root.data;
		int oneSideSum = Math.max(currData, Math.max(r, l)+currData);		
		// numbers can be both positive and negative, thats why checking max with current node also
		
		int bothSideSum = Math.max(oneSideSum, r+l+currData);
		
		result = Math.max(bothSideSum, result);
		
		return oneSideSum;		// returning oneSideSum because in recursive call we need each node's oneSideSum, which we can then calculate with r and l
	}
}

class Node {
	 
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = right = null;
    }
}
