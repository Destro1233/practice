package javaCollections;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			System.out.println(isParenthesisMatch(input));
		}

	}

	public static boolean isParenthesisMatch(String str) {
		//if (str.charAt(0) == '{')
		//	return false;

		Stack<Character> stack = new Stack<Character>();

		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);

			if (c == '(')
				stack.push(c);
			else if (c == '{')
				stack.push(c);
                else if (c == '[')
				stack.push(c);
			else if (c == ')')
				if (stack.empty())
					return false;
				else if (stack.peek() == '(')
					stack.pop();
				else
					return false;
			else if (c == '}')
				if (stack.empty())
					return false;
				else if (stack.peek() == '{')
					stack.pop();
				else
					return false;
                else if (c == ']')
				if (stack.empty())
					return false;
				else if (stack.peek() == '[')
					stack.pop();
				else
					return false;
		}
		return stack.empty();
	}
}
