int maxTotalWeight(int[] weight, int w) {
	boolean[][] dp = new boolean[weight.length + 1][w];
	dp[0][0] = true;
	dp[0][weight[0]] = true;
	for (int i = 1; i < dp.length; i++) {
		for (int j = 1; j < dp[0].length; j++) {
			if (j - weight[i] < 0) {
				dp[i][j] = dp[i - 1][j];
			} else {
				dp[i][j] = dp[i - 1][j] || dp[i - 1][j - weight[i]];
			}
		}
	}
	for (int i = dp[0],length - 1; i >= 0; i--) {
		if (dp[dp.length - 1][i]) {
			return i;
		}
	}
	return 0;
}