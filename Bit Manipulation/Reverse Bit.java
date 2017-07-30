public int reverse(int num) {
	for (int i = 0; i < 16; i++) {
		int right = ((num >> i) & 1);
		int left = ((num >> (32 - i)) & 1);
		if (right != left) {
			num ^= (1 << i);
			num ^= (1 << 32 - i);
		}
	}
	return num;
}