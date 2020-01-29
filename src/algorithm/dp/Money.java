package algorithm.dp;

/**
 * 有1,5,11三种钞票，对任意金额M，给出最少的钞票数量
 */
public class Money {
	public static int leastCount(int money){
		int[] f = new int[money+1];
		f[0] = 0;
		for (int i = 1; i <= money; i++) {
			int temp = f[i-1] + 1;
			if (i - 5 >= 0) {
				temp = Math.min(temp, f[i-5] + 1);
			}
			if (i - 11 >= 0) {
				temp = Math.min(temp, f[i-11] + 1);
			}
			f[i] = temp;
			System.out.println(i + "元，最少需要" + temp + "张纸币");
		}
		return f[money - 1];
	}

	public static void main(String[] args) {
		System.out.println(leastCount(100));
		assert leastCount(15) == 3;
	}
}
