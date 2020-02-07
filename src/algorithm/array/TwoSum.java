package algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++){
			if (map.get(nums[i]) != null){
				return new int[]{map.get(nums[i]) + 1, i + 1};
			}
			map.put(target-nums[i], i);
		}
		throw new RuntimeException();
	}

	public static void main(String[] args) {
		int[] example = {2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(example,9)));
	}
}
