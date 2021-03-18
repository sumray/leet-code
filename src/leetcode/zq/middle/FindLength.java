package leetcode.zq.middle;

// https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
// 最长重复子数组
public class FindLength {

	public static int findLength(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];
		int max = 0;
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				dp[i][j] = A[i-1] == B[j-1] ? dp[i-1][j-1] + 1 : 0;
				max = Math.max(dp[i][j], max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] p1 = {1, 2, 3, 2, 1};
		int[] p2 = {3, 2, 1, 4, 7};
		System.out.println(findLength(p1, p2));
	}

}
