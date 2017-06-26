1. Element Deduplication and Removal in the array
隔板题：
Two pointer: fast and slow with the same direction.
Property:
1) slow 隔板左边是处理好的元素，fast 右边是未处理的元素，之间的区域是无用区域，每次只要分析当前元素是否加入和移动slow 挡板。
2）同向而行，return 的结果中相对位置不变。

Two pointer: start and end with the different directions. -> Similar to Rainbow Sort
Property:
1) the left side to start is processed elements and the right side to end is processed elements, the middle part
   -> [left, right] is unkown area.
2) do not maintain the relative order.