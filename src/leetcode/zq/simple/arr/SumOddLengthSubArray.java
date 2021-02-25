package leetcode.zq.simple.arr;

public class SumOddLengthSubArray {

	public static int sumOddLengthSubarrays(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		int res = 0;
		for (int size = 1; size <= arr.length; size = size + 2) {
			for (int i = 0, j = i + size; j <= arr.length; i++, j = i + size) {
				res += calculate(arr, i, j);
			}
		}
		return res;
	}

	private static int calculate(int[] arr, int start, int end) {
		int res = 0;
		for (int i = start; i < end; i++) {
			res += arr[i];
		}
		return res;
	}

	//以{1,2,3,4,5}为例，计算i为某确定值时候对应arr[i]出现的总次数。
	private static int otherPeople(int[] arr) {
		int sum = 0;
		int len = arr.length;
		for (int i = 0; i < arr.length; i++) {
			//当i = 2时候，arr[2] = 3,左边有2个元素1，2，
			//需要保证连续，则取元素方式如下:
			//取0个:{3}
			//取1个:只取一个元素2.则{2,3}
			//取2个:取2个元素1和2,则{1,2,3}
			//所以有3种情况就是2+1种情况，也就是i+1种情况
			int left = i + 1;
			//右边元素个数为：len-(i+1)个
			//同理可得
			int right = len - (i + 1) + 1;
			//左边取的元素个数0,1,2；则只有1为奇数，可得左边取奇数个元素的方式：
			int left_odd = left / 2;
			//左边取的元素个数0,1,2；则偶数为0个或者2个，可得左边取偶数个元素的方式：
			int left_even = (left + 1) / 2;
			//同上，右边取奇数个元素的方式
			int right_odd = right / 2;
			//同上，右边取偶数个元素的方式
			int right_even = (right + 1) / 2;
			//左边取任意奇数个同时右边取任意奇数个加上自身，一共奇数个。任意组合所以是乘法。
			//左边取任意偶数个同时右边取任意偶数个加上自身，一共奇数个。
			//注意包含左右各取0个。
			sum += arr[i] * (left_odd * right_odd + left_even * right_even);
		}
		return sum;
	}

	public static void main(String[] args) {
		int [] par = {1, 4, 2, 5, 3};
		System.out.println(sumOddLengthSubarrays(par));
	}

}
