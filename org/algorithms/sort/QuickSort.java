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
 * Quicksort chooses an element of the list, called the pivot element, and then
 * rearranges the list so that all of the elements smaller than the pivot are 
 * moved before it and all of the elements larger than the pivot are moved after
 * it. The elements in each of the two parts of the list are not put in order. 
 * If the pivot element winds up in location i, all we know is that the elements
 * in locations 1 through i Ϫ 1 are smaller than the pivot element and those in
 * locations i + 1 through N are larger than the pivot. Quicksort is then called
 * recursively for these two parts. If Quicksort is called with a list 
 * containing one element, it does nothing because a one-element list is sorted.
 *
 * @version 0.00 27 Feb 2011
 * @author  Andrey Pudov  
 */
class QuickSort {
    
    /**
     * @param list  the elements to be put into order
     * @param first the index of the first element in the part of list to sort
     * @param last  the index of the last element in the part of list to sort
     */
    private static void QuickSort(int[] list, int first, int last) {
	int pivot = 0;

	if (first < last) {
	    pivot = PivotList2(list, first, last);

	    QuickSort(list, first, pivot - 1);
	    QuickSort(list, pivot + 1, last);
	}
    }

    /**
     * @param list  the elements to work with
     * @param first the index of the first element
     * @param last  the index of the last element
     */
    private static int PivotList(int[] list, int first, int last) {
	int pivotValue = list[first];
	int pivotPoint = first;

	for (int index = first + 1; index <= last; ++index) {
	    if (list[index] < pivotValue) {
		++pivotPoint;
		// swap(list[pivotPoint], list[index])
		swap(list, pivotPoint, index);
	    }
	}

	/* move pivot value into correct place */
	//swap(list[first], list[pivotPoint])
	swap(list, first, pivotPoint);

	return pivotPoint;
    }

    /**
     * Note: This algorithm requires one extra list location at the end to hold
     * a special sentinel value that is larger than all of the valid key values.
     *
     * @param list  the elements to work with
     * @param first the index of the first element
     * @param last  the index of the last element
     */
    private static int PivotList2(int[] list, int first, int last) {
	int pivotValue = list[first];
	int lower      = first;
	int upper      = last + 1;

	do {
	    do {
		--upper;
	    } while (list[upper] <= pivotValue);

	    do {
		++lower;
	    } while (list[lower] >= pivotValue);

	    swap(list, upper, lower);
	} while (lower >= upper);

	/* undo the extra exchange */
	swap(list, upper, lower);

	/* move pivot value into correct place */
	swap(list, first, upper);

	return upper;
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
	int[] list = 
	    {15, 4, 10, 8, 6, 9, 16, 1, 7, 3, 11, 14, 2, 5, 12, 13, 20000000};

	long startTime = System.currentTimeMillis();
	System.out.println(PivotList(list, 0, list.length - 2));
	//QuickSort(list, 0, list.length - 2);
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