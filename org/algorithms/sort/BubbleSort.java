/**
 * Copyright (C) 2011 by Andrey Pudov
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * The bubble sort algorithm makes a number of passes through the list of 
 * elements. On each pass it compares adjacent element values. If they are out 
 * of order, they are swapped. We start each of the passes at the beginning of 
 * the list and compare the elements in locations 1 and 2, then the elements in
 * locations 2 and 3, then 3 and 4, and so on, swapping those that are out of 
 * order. On the first pass, once the algorithm reaches the largest element, it
 * will be swapped with all of the remaining elements, moving it to the end of 
 * the list after the first pass. The second pass, therefore, no longer needs to
 * look at the last element in the list. The second pass will move the second 
 * largest element down the list until it is in the second to last location. 
 * The process continues with each additional pass moving one more of the larger
 * values down in the list. During all of this, the smaller values are also 
 * moving toward the front of the list. If on any pass there are no swaps, all 
 * of the elements are now in order and the algorithm can stop. It should be 
 * noted that each pass has the potential of moving a number of the elements 
 * closer to their final position, even though only the largest element on that  * pass is guaranteed to wind up in its final location.
 *
 * @version 0.00 27 Feb 2011
 * @author  Andrey Pudov  
 */
class BubbleSort {

    /**
     * @param list the elements to be put into order
     * @param n    the number of elements in the list
     */
    private static void BubbleSort(int[] list, int n) {
	int     numberOfPairs   = n;
	boolean swappedElements = true;

	while (swappedElements) {
	    --numberOfPairs;
	    swappedElements = false;

	    for (int i = 0; i < numberOfPairs; ++i) {
		if (list[i] > list[i + 1]) {
		    // swap(list[i], list[i+1])
		    swap(list, i, i + 1);
		    swappedElements = true;
		}
	    }
	}
    }

    /**
     * interchange inside array
     *
     * The swapping just above using reference parameters in C doesn't work in 
     * Java, since Java doesn't have these kind of parameters, but often an 
     * application really only needs to swap two values in an array. In this 
     * case one can pass the array and the two indexes to swap as three 
     * parameters, and this will work in Java. The "bubble sort" program below 
     * illustrates this.
     */
    private static void swap(int[] a, int i, int j) {
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
    }

    public static void main(String[] args) {
	int[] list = {15, 4, 10, 8, 6, 9, 16, 1, 7, 3, 11, 14, 2, 5, 12, 13};

	long startTime = System.currentTimeMillis();
	BubbleSort(list, list.length);
	long endTime = System.currentTimeMillis();
	float seconds = (endTime - startTime) / 1000F;

	System.out.print("list:");
	for (int i = 0; i < list.length; i++) {
	    System.out.print(" " + list[i]);
	}
	System.out.print('\n');

	System.out.println(Float.toString(seconds) + " seconds.");
    }
}