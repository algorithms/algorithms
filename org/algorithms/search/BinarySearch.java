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
 * In computer science, a binary search or half-interval search algorithm 
 * locates the position of an item in a sorted array. Binary search works  
 * by comparing an input value to the middle element of the array. The 
 * comparison determines whether the element equals the input, less than the 
 * input or greater. When the element being compared to equals the input the 
 * search stops and typically returns the position of the element. If the 
 * element is not equal to the input then a comparison is made to determine 
 * whether the input is less than or greater than the element. Depending on 
 * which it is the algorithm then starts over but only searching the top or 
 * bottom subset of the array's elements. If the input is not located within the
 * array the algorithm will usually output a unique value indicating this. 
 * Binary search algorithms typically halve the number of items to check with
 * each successive iteration, thus locating the given item (or determining its 
 * absence) in logarithmic time. A binary search is a dichotomic divide and 
 * conquer search algorithm.
 *
 * @version 0.00 06 Feb 2011
 * @author  Andrey Pudov
 */
public class BinarySearch {

    /**
     * @param list   the elements to be searching
     * @param target the value being searched for
     * @param n	     the number of elements in the list
     * @return	     index of the search key
     */
    public static int search(int[] list, int target, int n) {
	int start = 0;
	int middle;
	int end = n - 1;

	while (start <= end) {
	    middle = (start + end) / 2;
	    switch (compare(list[middle], target)) {
	    case -1:
		/* list[middle] < target */
		start = middle + 1;
		break;
	    case 0:
		/* list[middle] == target */
		return middle;
	    case 1:
		/* list[middle] > target */
		end = middle - 1;
		break;
	    default:
		/* falls trhough */
	    }
	}
	
	return -1;
    }

    /**
     *                 |-1 if x < y
     * Compare(x, y) = | 0 if x = y
     *                 | 1 if x > y
     *
     * The Compare function should be counted as one comparison and can best be
     * used in a switch.
     */
    private static int compare(int x, int y) {
	if (x < y) {
	    return -1;
	} else if (x == y) {
	    return 0;
	} else {
	    /* x > y */
	    return 1;
	}
    }

    public static void main(String[] args) {
	/** the maximum size of an array */
	int MAX_LEN = 20000000;

	/** the value being searched for (random int >= 0 and < n) */
	int target  = new java.util.Random().nextInt(MAX_LEN);
	System.out.println("target: " + target);

	int[] sorted = new int[MAX_LEN];
	for (int i = 0; i < sorted.length; i++) {
	    sorted[i] = i;
	}

	long startTime = System.currentTimeMillis();
	search(sorted, target, sorted.length);
	long endTime = System.currentTimeMillis();
	float seconds = (endTime - startTime) / 1000F;
	System.out.println(Float.toString(seconds) + " seconds.");
    }
}
