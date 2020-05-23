package algorithm.binary_search;

public class MountainArray {
	public static int peakIndexInMountainArray(int[] A) {
		int lo = 0;
		int hi = A.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (A[mid] < A[mid + 1]) {
				lo = mid + 1;
			} else if (A[mid - 1] > A[mid]) {
				hi = mid;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a1 = {-1, 1, 2, 3,1};
		int[] a2 = {2,3,4,3,1};
		int[] a3 = {18,29,38,59,98,100,99,98,90};
		// 3
		System.out.println(peakIndexInMountainArray(a1));
		// 2
		System.out.println(peakIndexInMountainArray(a2));
		// 5
		System.out.println(peakIndexInMountainArray(a3));
	}
}
