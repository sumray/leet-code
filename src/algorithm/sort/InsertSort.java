package algorithm.sort;

import java.util.Arrays;

public class InsertSort {

	public static void sort(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			int val = arr[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (arr[j] > val) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = val;
		}
	}

	public static void main(String[] args) {
		int[] arr = {3, 1, 99, 46, 102, 55, 12, 31, 0, 2, 2, 99};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
