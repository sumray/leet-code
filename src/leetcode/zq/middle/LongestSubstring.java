package leetcode.zq.middle;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static int longestSubstring(String s, int k) {
		if (s.length() < k) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) < k) {
				sb.setCharAt(i, ',');
			}
		}
		String[] arr = sb.toString().split(",");
		if (arr.length == 1) {
			return arr[0].length();
		}
		int max = 0;
		for (String str : arr) {
			int m = longestSubstring(str, k);
			if (m > max) {
				max = m;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s1 = "aaabb";
		int k = 3;
		String s2 = "ababbc";
		int k2 = 2;
		String s3 = "ababacb";
		int k3 = 3;

		System.out.println(longestSubstring(s1, k));    // 3
		System.out.println(longestSubstring(s2, k2));    // 5
		System.out.println(longestSubstring(s3, k3));    // 5
	}

}
