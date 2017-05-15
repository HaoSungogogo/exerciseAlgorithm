We need to consider the three cases:
1: 0 ^ 0 -> meaningless
2: the power is negative.
3: the power is positive.

class Solution {
	public void power(int a, int b) {
		if (a == 0 && b == 0) {
			System.out.println("the parameter is error");
			return;
		}
		double result;
		if(b < 0) {
			result = (double)1 / pow(a, -b);
		}else {
			result = (double) pow(a, b);
		}
		System.out.println("the result is: " + result);
	}
	private long pow(int a, int b) {
		if(b == 0) {
			return (long) 1;
		}
		long temp = pow(a, b / 2);
		if(b % 2 == 0) {
			return temp * temp;
		}else {
			return temp * temp * a;
		}
	}
}