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
 * The basic idea of insertion sort is that if you have a list that is sorted
 *  and need to add a new element, the most efficient process is to put that 
 * new element into the correct position instead of adding it anywhere and then
 * resorting the entire list. Insertion sort accomplishes its task by 
 * considering that the first element of any list is always a sorted list of 
 * size 1. We can create a two-element sorted list by correctly inserting the 
 * second element of the list into the one element list containing the first 
 * element. We can now insert the third element of the list into the two-element
 * sorted list. This process is repeated until all of the elements have been put
 * into the expanding sorted portion of the list.
 *
 *
 * @version 0.00 27 Feb 2011
 * @author  Andrey Pudov  
 */
class InsertionSort {

    /**
     * @param list the elements to be put into order
     * @param n    the number of elements in the list
     */
    private static void InsertionSort(int[] list, int n) {
	int newElement = 0;
	int location = 0;

	for (int i = 1; i < n; ++i) {
	    newElement = list[i];
	    location = i - 1;

	    while ((location >= 0) && (list[location] > newElement)) {
		/* move any larger elements out of the way */
		list[location + 1] = list[location];
		location = location - 1;
	    }

	    list[location + 1] = newElement;
	}
    }

    public static void main(String[] args) {
	int[] list = {15, 4, 10, 8, 6, 9, 16, 1, 7, 3, 11, 14, 2, 5, 12, 13};

	long startTime = System.currentTimeMillis();
	InsertionSort(list, list.length);
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