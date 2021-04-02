package practice;

import java.util.Deque;
import java.util.LinkedList;

public class Demo {

	public int calculate(String s) {
		char[] arr = s.toCharArray();
		Deque<Character> operStack = new LinkedList<>();
		Deque<Integer> numStack = new LinkedList<>();
		int temp = -1;
		for (char c : arr) {
			if (c == ' ') {
				continue;
			}
			if (!isOperator(c)) {
				if (temp == -1) {
					temp = toInt(c);
				} else {
					temp = temp * 10 + toInt(c);
				}
				continue;
			}
			if (temp != -1) {
				numStack.push(temp);
				temp = -1;
			}
			if (operStack.isEmpty() || isHigher(operStack.peek(), c)) {
				operStack.push(c);
				continue;
			}
			while (!operStack.isEmpty() && !isHigher(operStack.peek(), c)) {
				char oper = operStack.pop();
				int i2 = numStack.pop();
				int i1 = numStack.pop();
				numStack.push(calculate(i1, i2, oper));
			}
			operStack.push(c);
		}
		if (temp != -1) {
			numStack.push(temp);
			temp = -1;
		}
		while (!operStack.isEmpty()) {
			char oper = operStack.pop();
			int i2 = numStack.pop();
			int i1 = numStack.pop();
			numStack.push(calculate(i1, i2, oper));
		}
		return numStack.pop();
	}

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private int toInt(char c) {
		return Integer.parseInt(String.valueOf(c));
	}

	private boolean isHigher(char c1, char c2) {
		if (c1 == '+' || c1 == '-') {
			return c2 == '*' || c2 == '/';
		}
		return false;
	}

	private int calculate(int i1, int i2, char c) {
		switch(c) {
			case '+':
				return i1 + i2;
			case '-':
				return i1 - i2;
			case '*':
				return i1 * i2;
			case '/':
				return i1 / i2;
		}
		return 0;
	}

	public static void main(String[] args) {
		Demo d = new Demo();
//		System.out.println(d.calculate("14/3*2"));
		System.out.println('c' - 'a');
		System.out.println('z' - 'a');
		System.out.println('a' - 'a');
		System.out.println('Z' - 'a');
	}

}
