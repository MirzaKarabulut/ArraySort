# SORT ALGORITHMS

(1) Write a class called ArraySort whose fields and constructor are the same as those of the
ArrayBub, ArraySel and ArrayIns classes. Then copy the insert(), display(), swap(), bubbleSort(),
selectionSort() and insertionSort() methods from those three classes and paste into the ArraySort class.
This class will be essentially the same as those three classes except that it will contain all three sorting
methods.

(2) To the ArraySort class, add another sorting method called oddEvenSort() which repeatedly
makes two passes through the array. On the first pass you look at all the pairs of items, a[j] and a[j + 1],
where j is even (j = 0, 2, 4, . . .). If their key values are out of order, you swap them. On the second pass
you do the same for all the odd values (j = 1, 3, 5, . . .). You do these two passes repeatedly until the
array is sorted. You need to figure out how many times to do the two passes.

(3) Modify the bubbleSort(), selectionSort(), insertionSort() and oddEvenSort() methods so that
they remove duplicates while sorting and keep only unique values. For example the array 7 5 2 7 8 2
3 2 should become 2 3 5 7 8 after sorting. While modifying these methods, you may assume that the
keys of all items in the array are nonnegative integers. You should modify these methods so that while
comparing two items if both items have the same key then one of them (you should determine which) is
changed to -1. You should also keep track of the number of duplicates and shift the array left by that
amount and modify the number of elements at the end.

(4) Write another version of modified selectionSort() so that you keep track of the number of
duplicates and after finding the item from a[out] to a[nElems − 1] with the smallest key, you place this
item at position out − noOfDuplicates instead of position out. You will have to modify the number of
elements at the end.
