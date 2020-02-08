package algorithm.array;

public class FindEvenDigitsNumber {
	public static int findNumbers(int[] nums) {
		int result = 0;
		for (int i=0; i<nums.length; i++){
			if (String.valueOf(nums[i]).length() % 2 == 0){
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] example = {12, 345, 2, 6, 7896};
		System.out.println(findNumbers(example));
	}
}
