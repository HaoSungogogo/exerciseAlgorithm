Unsigned int max -> 2^32 - 1
Negative Number 取反加1

Key of thinking:
XOR want to flip on the certain bit, XOR 1
OR set 1
set 0, 1 shift, 取反 ~, AND

<< left shift, 右侧补零
>> right shift, if it is positive, 左侧补零
				if it is negative, 左侧补1

1 char  -> 8 bits
bit map and bit vector

Given a number x, how to set x kth bit to 1?

public int setOne (int x, int k) {
	int OR = 1 << k;
	return x | OR;
}

Given a number x, how to set x kth bit to 0?

public int setZero (int x, int k) {
	int bitMask = 1 << k;
	return x & ~bitMask;
}

Determine whether a number is power of 2?
mathod1:
public boolean isPower(int cur) {
	if (cur == 0) {
		return false;
	}
	int remain = 0;
	while (remain == 0) {
		remian = cur % 2;
		cur = cur / 2;
	}
	return cur == 0;
}
method2:
(n > 0) && (n & (n - 1) == 0)

How to determine the number of bits that are different betwenen two positive integers?

public int diff (int a, int b) {
	int c = a ^ b;
	return bitCount(c);
}
private int bitCount(int c) {
	int count = 0;
	while (c != 0) {
		if (c & 1 == 1) {
			count++;
		}
		c = c >> 1;
	}
	return count;
}


