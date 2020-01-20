package leetcode.zq.simple;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0){
			return true;
		}
		Stack<Character> stack = new Stack<>();
		char[] pars = s.toCharArray();
		for (char c : pars) {
			if (c == '(' || c == '[' || c == '{'){
				stack.push(c);
				continue;
			}
			if (stack.empty()) {
				return false;
			}
			char left = stack.peek();
			if ((left == '(' && c != ')')
				|| (left == '[' && c != ']')
				|| (left == '{' && c != '}')){
				return false;
			}
			stack.pop();
			if (stack.empty()){
				return true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidParentheses v = new ValidParentheses();
		String s = "({})";
		String s2 = "()";
		String s3 = "(())";
		String s4 = "([)]";
		System.out.println(v.isValid(s));
		System.out.println(v.isValid(s2));
		System.out.println(v.isValid(s3));
		System.out.println(v.isValid(s4));
	}
}
