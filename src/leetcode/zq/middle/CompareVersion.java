package leetcode.zq.middle;

/**
 * https://leetcode-cn.com/problems/compare-version-numbers/submissions/
 */
public class CompareVersion {

	public int compareVersion(String version1, String version2) {
		String[] v1Arr = version1.split("\\.");
		String[] v2Arr = version2.split("\\.");
		int len = v1Arr.length > v2Arr.length ? v1Arr.length : v2Arr.length;
		int[] i1Arr = convertToIntArr(v1Arr, len);
		int[] i2Arr = convertToIntArr(v2Arr, len);

		for (int i = 0; i < i1Arr.length; i++) {
			int i1 = i1Arr[i];
			int i2 = i2Arr[i];
			if (i1 > i2) {
				return 1;
			}
			if (i1 < i2) {
				return -1;
			}
		}
		return 0;
	}

	private int[] convertToIntArr(String[] arr, int length) {
		int[] res = new int[length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = removeZero(arr[i]);
		}
		return res;
	}

	private int removeZero(String s) {
		if (s.length() == 1 || s.charAt(0) != '0') {
			return Integer.valueOf(s);
		}
		char[] arr = s.toCharArray();
		int i = 0;
		for (; i < arr.length; i++) {
			if (i != '0') {
				break;
			}
		}
		if (i == arr.length - 1) {
			return 0;
		}
		return Integer.valueOf(s.substring(i+1));
	}

	public static void main(String[] args) {
		CompareVersion v = new CompareVersion();
		System.out.println(v.compareVersion("1.0", "1.0.0"));
	}

}
