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
 * In computer science, linear search or sequential search is a method for 
 * finding a particular value in a list, that consists of checking every one of 
 * its elements, one at a time and in sequence, until the desired one is found.
 * 
 * Linear search is the simplest search algorithm; it is a special case of 
 * brute-force search. Its worst case cost is proportional to the number of 
 * elements in the list; and so is its expected cost, if all list elements are 
 * equally likely to be searched for. Therefore, if the list has more than a 
 * few elements, other methods (such as binary search or hashing) may be much 
 * more efficient.
 * 
 * @version 0.00 02 Feb 2011
 * @author  Andrey Pudov
 */
public class SequentialSearch {
    /* Worst-Case Analysis - N */
    /* 
     * Average-Case Analysis - 
     * 1 / (N + 1) * sum[i, {i, 1, N}] + 1 / (N + 1) * N 
     * ~~(N + 2) / 2
     */
	
    /**
     * @param list   the elements to be searching
     * @param target the value being searched for
     * @param n	     the number of elements in the list
     * @return	     index of the search key
     */
    public static int search(int[] list, int target, int n) {
	
	for (int i = 0; i < n; i++) {
	    if (target == list[i]) {
		return i;
	    }
	}
		
	return -1;
    }

    public static void main(String[] args) {
	/** the maximum size of an array */
	int MAX_LEN = 20000000;

	/** the value being searched for (random int >= 0 and < n) */
	//int target  = new java.util.Random().nextInt(MAX_LEN);
	int target = MAX_LEN / 2;
	System.out.println("target: " + target);

	/* search in sorted array */
	int[] sorted = new int[MAX_LEN];
	for (int i = 0; i < sorted.length; i++) {
	    sorted[i] = i;
	}

	long startTime = System.currentTimeMillis();
	search(sorted, target, sorted.length);
	long endTime = System.currentTimeMillis();
	float seconds = (endTime - startTime) / 1000F;
	System.out.println(Float.toString(seconds) + " seconds.");

	/* search in unsorted array */		
	int[] unsorted = new int[MAX_LEN];
	for (int i = 0; i < unsorted.length; i++) {
	    unsorted[i] = unsorted.length - i;
	}

	startTime = System.currentTimeMillis();
	search(unsorted, target, unsorted.length);
	endTime = System.currentTimeMillis();
	seconds = (endTime - startTime) / 1000F;
	System.out.println(Float.toString(seconds) + " seconds.");
    }
}
