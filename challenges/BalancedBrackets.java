package challenges;

import java.util.ArrayDeque;

public class BalancedBrackets {
	public static void main(String[] args) {
		System.out.println(isBalanced("([{{[(())]}}])"));
		System.out.println(isBalanced("[()()]{}"));
		System.out.println(isBalanced("[()()]{})"));
	}

	static boolean isBalanced(String s) {
		boolean balanced = true;
		ArrayDeque<Character> stack = new ArrayDeque<>();

		for(char c: s.toCharArray()) {
			if(c=='(' || c=='{' || c=='[') {
				stack.addFirst(c);
			} else {
				if(!stack.isEmpty() &&
						((stack.peekFirst()=='(' && c==')') ||
				   		(stack.peekFirst()=='{' && c=='}') ||
				   		(stack.peekFirst()=='[' && c==']'))
				) {
					stack.pollFirst();
				} else {
					balanced = false;
					break;
				}
			}
		}
		return balanced;
	}
}
