package leetcode.zq.simple;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeSellStock {

	public static int maxProfit(int[] prices) {
		int finMax = 0;
		int maxCur = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(maxCur + prices[i] - prices[i-1], 0);
			finMax = Math.max(maxCur, finMax);
		}
		return finMax;
	}

	public static int maxProfit2(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(prices[i] - min, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] example = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(example));
		System.out.println(maxProfit2(example));
	}
}
