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
 * A related technique to find the Kth largest value in the list is to find the
 * largest value and then move it to the last location in the list. If we again
 * look for the largest value in the list, ignoring the value we already found,
 * we get the second largest value, which can be moved to the second last 
 * location in the list. If we continue this process, we will find the Kth 
 * largest value on the Kth pass.
 *
 * @version 0.00 26 Feb 2011
 * @author  Andrey Pudov  
 */
class FindKthLargest {

    /**
     * @param list the values to look through
     * @param n    the size of the list
     * @param k    the element to select
     * @return	   the the kth largest value
     */
    private static int findKthLargest(int[] list, int n, int k) {
	int largest         = 0;
	int largestLocation = 0;

	for (int i = 0; i < k; ++i) {
	    largest = list[0];
	    largestLocation = 0;

	    for (int j = 1; j < (n - i); ++j) {
		if (list[j] > largest) {  
		    largest = list[j];
		    largestLocation = j;
		}
	    }

	    swap(list, (n - i) - 1, largestLocation);
	}

	return largest;
    }

    /**
     * FIXME - don't work
     *
     * @param list  the values to look through
     * @param start the index of the first value to consider
     * @param end   the value of the last value to consider
     * @param k     the element of this list that we want
     */
    private static int findKthLargestRecursive(
            int[] list, int start, int end, int k) {
	int p = partition(list, start, end, (end - start) / 2);

	if (p == k) {
	    return list[p];
	} else {
	    if (k < p) {
		return findKthLargestRecursive(list, p + 1, end, k);
	    } else {
		return findKthLargestRecursive(list, start, p - 1, k - p);
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

    private static int partition(int[] list, int start, int end, int middle) {
	/* temporary - don't use it  */

	middle = list[middle];
	java.util.Arrays.sort(list, start, end);

	return java.util.Arrays.asList(list).indexOf(middle);
    }

    public static void main(String[] args) {
	/** the maximum size of an array */
	int MAX_LEN = 10;

	/** the value being searched for (random int >= 0 and < n) */
	//int target  = new java.util.Random().nextInt(MAX_LEN);
	int target = 3;
	System.out.println("target: " + target);

	System.out.print("list:");
	int[] list = new int[MAX_LEN];
	for (int i = 0; i < list.length; i++) {
	    list[i] = MAX_LEN - i;
	    System.out.print(" " + list[i]);
	}
	System.out.print('\n');

	long startTime = System.currentTimeMillis();
	//System.out.println(findKthLargest(list, list.length, target));
	System.out.println(findKthLargestRecursive(
	    list, 0, list.length - 1, target));
	long endTime = System.currentTimeMillis();
	float seconds = (endTime - startTime) / 1000F;
	System.out.println(Float.toString(seconds) + " seconds.");
    }
}