package practice;

import java.util.Arrays;

public class Demo {

	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private void sort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int p = quick(arr, left, right);
		sort(arr, left, p - 1);
		sort(arr, p + 1, right);
	}

	private int quick(int[] arr, int left, int right) {
		int p = arr[left];
		int i = left;
		int j = right;
		while (i < j) {
			while (i < j && arr[j] > p) {
				j--;
			}
			if (i < j) {
				arr[i++] = arr[j];
			}
			while (i < j && arr[i] < p) {
				i++;
			}
			if (i < j) {
				arr[j--] = arr[i];
			}
		}
		arr[i] = p;
		return i;
	}

	public static void main(String[] args) {
		int[] arr = {3, 1, 99, 46, 102, 55, 12, 31, 0, 2, 2, 99};
		Demo d = new Demo();
		d.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
