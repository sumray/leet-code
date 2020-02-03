package leetcode.zq.simple;

import java.util.*;

/**
 * https://leetcode.com/problems/single-number/description/
 */
public class SingleNumber {

	public static int singleNumber(int[] nums) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int num : nums) {
			if (set.contains(num)){
				set.remove(num);
			} else{
				set.add(num);
			}
		}
		return set.first();
	}

	public static int singleNumber2(int[] nums) {
		int ans =0;

		int len = nums.length;
		for(int i=0;i!=len;i++)
			ans ^= nums[i];

		return ans;
	}


	public static void main(String[] args) {
		int[] e1 = {4, 1, 2, 1, 2};
		int[] e2 = {2,2,1};
		System.out.println(singleNumber(e1));
		System.out.println(singleNumber(e2));
	}
}
