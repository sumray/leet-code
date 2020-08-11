package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void sort(int[] arr, int left, int right) {
		if (arr.length < 2) {
			return;
		}
		if (left >= right) {
			return;
		}
		int i = left;
		int j = right;
		int p = arr[left];
		while (i < j) {
			while (i < j && arr[j] >= p) {
				j--;
			}
			if (i < j) {
				arr[i++] = arr[j];
			}
			while (i < j && arr[i] <= p) {
				i++;
			}
			if (i < j) {
				arr[j--] = arr[i];
			}
		}
		arr[i] = p;
		sort(arr, left, i - 1);
		sort(arr, i + 1, right);
	}

	public static void main(String[] args) {
		int[] arr = {3, 1, 99, 46, 102, 55, 12, 31, 0, 2, 2, 99};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
}
