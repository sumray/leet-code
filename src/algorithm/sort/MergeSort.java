package algorithm.sort;

import java.util.Arrays;

public class MergeSort {

	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private void sort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		sort(arr, left, mid);
		sort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	private void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		k = 0;
		while (left <= right) {
			arr[left++] = temp[k++];
		}
	}

	public static void main(String[] args) {
		int[] arr = {3, 1, 99, 46, 102, 55, 12, 31, 0, 2, 2, 99};
		MergeSort m = new MergeSort();
		m.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
