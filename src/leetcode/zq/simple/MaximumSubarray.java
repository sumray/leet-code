package leetcode.zq.simple;

/**
 * https://leetcode.com/problems/maximum-subarray
 */
public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 0;
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			max = Math.max(dp[i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
