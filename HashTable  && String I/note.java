HashTable:
	HashSet is a set.
	HashMap is <Key, Value> pair.

String common problem:

Key method: It is similar to array problem. Using two pointer.

1. Removal
	a). remove particular chars from a string.
	b). remove all leading/trailing/duplicate empty spaces from a string.
	
Method: (two pointer)	
	Two blocks, Three area, Same direction
	i = 0, all letters to the left sides of i are processed letters that should not be removed.
	j = 0, j is the current index to move, [i, j] do not care.
	(j, size - 1), unknown area.

new String(arr, (offset), (length));

2. Deduplication
	two pointer way.

3. SubString problem
	travese is ok.