package leetcode.zq.simple.arr;

import java.util.Arrays;

// https://leetcode-cn.com/problems/merge-sorted-array/
public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) {
			return;
		}
		int i = 0;
		int j = 0;
		while (i < m) {
			if (nums1[i] <= nums2[j]) {
				i++;
				continue;
			}
			int curJ = j;
			while (curJ < n && nums1[i] > nums2[curJ]) {
				curJ++;
			}
			swap(nums1, nums2, i, j, curJ - j);
			i = i + (curJ - j);
			if (i >= m) {
			} else {
				j = 0;
			}
		}
		// 1 2 7
		// i = 2
		// i = 5
		// j = 0
		// j = 2
		// 3 4 8

		// 1 2 3
		// 7 4 8
		for (; i < nums1.length; i++) {
			nums1[i] = nums2[j++];
		}
	}

	private void swap(int[] nums1, int[] nums2, int start1, int start2, int times) {
		while (times-- > 0) {
			int temp = nums1[start1];
			nums1[start1] = nums2[start2];
			nums2[start2] = temp;
			start1++;
			start2++;
		}
	}

	public static void main(String[] args) {
		MergeSortedArray m = new MergeSortedArray();
		/*
		[4,0,0,0,0,0]
1
[1,2,3,5,6]
5
		 */
		int[] a1 = {4,0,0,0,0,0};
		int[] a2 = {1,2,3,5,6};
		m.merge(a1, 1, a2, 5);
		System.out.println(Arrays.toString(a1));
	}

}
