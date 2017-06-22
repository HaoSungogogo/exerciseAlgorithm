4. Reversal or Swap
	a). Reverse the whole String: 
			iterative way 
			recursive way
	b). I love yahoo -> reverse the whole String and then reverse every single word
	c). Shift the string: abcdef -> efabcd
			reverse the whole string
			reverse ef and abcd respectively

5. Replacement
	1. Getting Shorter
	2. Getting Longer

Advance topic:
1. Shuffling
	a. A1B2C3D4 -> ABCD1234
		(Merge Sort Way)
		A1B2  C3D4 
	  A1   B2 C3  D4 
	A 1   B  2 C 3 D 4
	AB12       CD34 
		ABCD1234

	b. ABCD1234 -> A1B2C3D4  (reverse a) -> (Reverse Merge Sort)

2. All Permutation (allowing duplicate)
	(aab) -> aab, aba, baa
	a. using set to find whether it is duplicate
	b. inplace swap and swap 

3. Encoding and Decoding (the same problem)
	a. Encoding: aabcccdd -> a2b1c3d2
		similar to char Replacement -> become shorter or longer
			step1: deal with the case make shorter 
			step2: deal with the case make longer
	b. Decoding: a1c0b2 -> abb
		similar to char Replacement -> become shorter or longer
			step1: deal with the case make shorter 
			step2: deal with the case make longer

4. Sliding Window in a string

	Longest Substring Without Repeating Characters -> slow and fast pointer
				(Unfixed sliding window)	     		slow: begin of the solution   fast: the current index
														At the same time, we maintain a Set

	All Anagrams -> Fixed sliding window
					Using HashMap to record the model
					Since the matches is the fixed length pattern, the length of sliding window is fixed. 
					So when we push it, we need to pop it.

	Longest subarray that contains all of 1s (allowing at most k 0s)
		-> It is also a sliding window problem, maintian a window that contains at most k 0s
			-> similar to problem1.




