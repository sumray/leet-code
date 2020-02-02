package leetcode.zq.simple;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeSellStock2 {

	public static int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			int cur = prices[i] - prices[i-1];
			if (cur >= 0){
				max += cur;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] example = {7,1,5,3,6,4};
		System.out.println(maxProfit(example));
	}
}
