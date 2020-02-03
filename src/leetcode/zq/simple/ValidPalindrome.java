package leetcode.zq.simple;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		int tail = s.length() - 1;
		int head = 0;
		char[] chars = s.toCharArray();
		for (; head < chars.length;){
			if (!Character.isLetterOrDigit(chars[head])) {
				head++;
				continue;
			}
			if (!Character.isLetterOrDigit(chars[tail])){
				tail--;
				continue;
			}
			if (Character.toLowerCase(chars[head])
				!= Character.toLowerCase(chars[tail])){
				return false;
			}
			head++;
			tail--;
			if (head >= tail){
				break;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
}
