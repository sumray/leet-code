package leetcode.zq.simple;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * 第一种方法：双指针（时间复杂度O(n),空间O(1)）
 * 第二种方法：HashMap存key值target-num[i]与value值j（时间复杂度O(n),空间O(n)）
 */
public class TwoSumInSortedArray {

	public static int[] twoSum(int[] numbers, int target) {
		for (int left=0,right=numbers.length-1;;) {
			if (numbers[left] + numbers[right] == target) {
				return new int[]{left + 1, right + 1};
			}
			if (numbers[left] + numbers[right] < target) {
				left++;
			} else {
				right--;
			}
		}
	}

	public static void main(String[] args) {
		int[] numbers = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}
}
