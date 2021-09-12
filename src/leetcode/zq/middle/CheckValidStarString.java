package leetcode.zq.middle;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/valid-parenthesis-string/submissions/
 */
public class CheckValidStarString {

	public boolean checkValidString(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Deque<Integer> main = new LinkedList<>();
		Deque<Integer> star = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				main.push(i);
				continue;
			}
			if (c == '*') {
				star.push(i);
				continue;
			}
			if (main.isEmpty()) {
				if (star.isEmpty()) {
					return false;
				}
				star.pop();
				continue;
			}
			main.pop();
		}
		while (!main.isEmpty()) {
			if (star.isEmpty()) {
				return false;
			}
			int m1 = main.pop();
			int s1 = star.pop();
			if (s1 < m1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CheckValidStarString demo = new CheckValidStarString();
		String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
		// false
		System.out.println(demo.checkValidString(s));
	}

}
