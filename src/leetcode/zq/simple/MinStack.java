package leetcode.zq.simple;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/submissions/
 * 最小值栈的存储可以由值转换为索引（待优化）
 */
public class MinStack {

	private Stack<Integer> data;
	private Stack<Integer> mins;

	public MinStack() {
		data = new Stack<>();
		mins = new Stack<>();
	}

	public void push(int x) {
		if (mins.empty() || mins.peek() >= x){
			mins.push(x);
		}
		data.push(x);
	}

	public void pop() {
		int top = top();
		if (mins.peek() == top) {
			mins.pop();
		}
		data.pop();
	}

	public int top() {
		return data.peek();
	}

	public int getMin() {
		return mins.peek();
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(0);
		stack.push(1);
		stack.push(0);
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}
}
