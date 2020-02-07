package leetcode.zq.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement {
	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int result = nums[0];
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
				result = num;
				continue;
			}
			map.put(num, map.get(num) + 1);
			if (map.get(num) > nums.length / 2){
				result = num;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] example = {2, 2, 1, 1, 1, 2, 2};
		System.out.println(majorityElement(example));
	}
}
