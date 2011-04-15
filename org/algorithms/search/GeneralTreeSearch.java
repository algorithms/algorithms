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
 * When the collection of data is large, there can still be a large number of
 * comparisons needed to do a binary search. For example, a telephone directory
 * of a large city could easily take about 25 comparisons per search. To improve
 * this, multiway searching uses a general tree, which is a tree data structure
 * that can have more than two children. In multiway searching, we store a few 
 * keys in each tree node, and the children represent the subtrees containing 
 * (a) the entries smaller than all the keys, (b) the entries larger than the 
 * first key but smaller than the rest, (c) the entries larger than the first 
 * two keys but smaller than the rest, and so on. The following figure shows an
 * example of a general tree that can be used for multiway searching. In the
 * root of this tree we have the keys of 6 and 10, so if we are looking for a 
 * key less than 6, we would take the left branch. If we are looking for a key
 * between 6 and 10, we would take the middle branch, and for a key larger than
 * 10, we would take the right branch.
 *
 *                                   (6/10)
 *                           /         |         \
 *                  (2/4)            ( 8 )              (12/14/16)
 *                 /  |  \           /   \            /   /     \   \
 *            ( 1 ) ( 3 ) ( 5 )   ( 7 ) ( 9 )   ( 11 ) ( 13 ) ( 15 ) ( 17 )
 *
 * @version 0.00 11 Feb 2011
 * @author  Andrey Pudov
 */
public class GeneralTreeSearch {

    /**
     * Returns a positive integer indicating the key that matches or a negative
     * integer indicating the link to take. 
     *
     * Eexamples:
     * compare([2, 6, 10], 6)
     *     would return a value of 1 because the second key matches.
     * compare([2, 6, 10], 7) 
     *     would return a value of –2 because 7 would be found on the third link
     *     associated with the gap between the second and third key value.
     */
    private static int compare

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
	//search(sorted, target, sorted.length);
	long endTime = System.currentTimeMillis();
	float seconds = (endTime - startTime) / 1000F;
	System.out.println(Float.toString(seconds) + " seconds.");
    }
}