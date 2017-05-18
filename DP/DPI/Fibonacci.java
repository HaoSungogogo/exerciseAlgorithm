Not like recursion, put the value into table in order

public int fibo(int n) {
	int[] fiboFound = new int[n + 1];
	fiboFound[0] = 0;
	fiboFound[1] = 1;
	for(int i = 2; i <= n; i++) {
		fiboFound[i] = fiboFound[i - 1] + fiboFound[i - 2];
	}
	return fiboFound;
}