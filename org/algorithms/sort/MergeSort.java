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
 * Merge sort can be written as a recursive algorithm that does its work on the
 * way up in the recursive process. In looking at the algorithm that follows, 
 * you will notice that it breaks the list in half as long as first is less than
 * last. When we get to a point where first and last are equal, we have a list
 * of one element, which is inherently sorted. When we return from the two calls
 * to MergeSort that have lists of size 1, we then call MergeLists to put those
 * together to create a sorted list of size 2. At the next level up, we will 
 * have two lists of size 2 that get merged into one sorted list of size 4.
 *  This process continues until we get to the top call, which merges the two 
 * sorted halves of the list back into one sorted list. We see that MergeSort 
 * breaks a list in halves on the way down in the recursive process and then 
 * puts the sorted halves together on the way back up. 
 *
 * @version 0.00 27 Feb 2011
 * @author  Andrey Pudov  
 */
class MergeSort {

    /**
     * @param list  the elements to be put into order
     * @param first the index of the first element in the part of list to sort
     * @param last  the index of the last element in the part of list to sort
     */
    private static void MergeSort(int[] list, int first, int last) {
	int middle = 0;

	if (first < last) {
	    middle = (first + last) / 2;

	    MergeSort(list, first, middle);
	    MergeSort(list, middle + 1, last);

	    MergeLists(list, first, middle, middle + 1, last);
	}
    }

    /**
     * @param list   the elements to be put into order
     * @param start1 beginning of “list” A
     * @param end1   end of “list” A
     * @param start2 beginning of “list” B
     * @param end2   end of “list” B
     */
    private static void MergeLists(
            int[] list, int start1, int end1, int start2, int end2) {
	int[] result = new int[(end1 - start1 + 1) + (end2 - start2 + 1)];

	/* assumes that the elements of A and B are contiguous in list */
	int finalStart = start1;
	int finalEnd   = end2;
	int indexC     = 0;

	while ((start1 <= end1) && (start2 <= end2)) {
	    if (list[start1] < list[start2]) {
		result[indexC] = list[start1];
		++start1;
	    } else {
		result[indexC] = list[start2];
		++start2;
	    }

	    ++indexC;
	}

	/* move the part of the list that is left over */
	if (start1 <= end1) {
	    for (int i = start1; i <= end1; ++i) {
		result[indexC] = list[i];
		++indexC;
	    }
	} else {
	    for (int i = start2; i <= end2; ++i) {
		result[indexC] = list[i];
		++indexC;
	    }
	}

	/* now put the result back into the list */
	indexC = 0;
	for (int i = finalStart; i <= finalEnd; ++i) {
	    list[i] = result[indexC];
	    ++indexC;
	}
    }

    public static void main(String[] args) {
	int[] list = {15, 4, 10, 8, 6, 9, 16, 1, 7, 3, 11, 14, 2, 5, 12, 13};

	long startTime = System.currentTimeMillis();
	MergeSort(list, 0, list.length - 1);
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