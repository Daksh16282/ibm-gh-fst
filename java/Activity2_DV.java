package fst;

public class Activity2 {

	static boolean isSum30(int[] arr) {
		int sum = 0;
		int res = 30;
		int req = 10;
		for (int x : arr) {
			if (x == req) {
				sum += x;
			}
			if (sum > res) {
				return false;
			}
		}

		return sum == res;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 77, 10, 54, -11, 10 };
		System.out.println(isSum30(arr));
	}
}
