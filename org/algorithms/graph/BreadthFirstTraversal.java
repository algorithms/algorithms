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
 * In a breadth-first traversal, we visit the starting node and then on the 
 * first pass visit all of the nodes directly connected to it. In the second 
 * pass, we visit nodes that are two edges “away” from the starting node. With 
 * each new pass, we visit nodes that are one more edge away. Because there 
 * might be cycles in the graph, it is possible for a node to be on two paths 
 * of different lengths from the starting node. Because we will visit that node
 * for the first time along the shortest path from the starting node, we will 
 * not need to consider it again. We will, therefore, either need to keep a list
 * of the nodes we have visited or we will need to use a variable in the node to
 * mark it as visited to prevent multiple visits.
 *
 * @version 0.00 28 Feb 2011
 * @author  Andrey Pudov  
 */
class BreadthFirstTraversal {

    private static boolean[] marked;
    private static int[]     queue;
    private static int       queuePos;

    /**
     * BreadthFirstTraversal(G, v)
     * Visit( v )
     * Mark( v )
     * Enqueue( v )
     * while the queue is not empty do
     *     Dequeue( x )
     *     for every edge xw in G do
     *         if w is not marked then
     *             Visit( w )
     *             Mark( w )
     *             Enqueue( w )
     *         end if
     *     end for
     * end while
     *
     * @param g is the graph
     * @param v is the current node
     */
    private static void BreadthFirstTraversal(int[][] g, int v) {
	/* visit(v) */ System.out.print( " -> " + v);
	marked[v] = true;
	enqueue(v);

	while (queuePos >= 0) {
	    int x = dequeue(); 
	    for (int w = 0; w < g[x].length; ++w) {
		if ((g[x][w] == 1) && (!marked[w])) {
		    /* visit(w) */ System.out.print( " -> " + w);
		    marked[w] = true;
		    enqueue(w);
		}
	    }
	}
    }

    private static void enqueue(int v) {
	queue[++queuePos] = v;
    }

    private static int dequeue() {
	return queue[queuePos--];
    }

    public static void main(String[] args) {
	/* adjacency matrix */
	int[][] adjmat = 
	    {{0, 1, 0, 0, 0, 0, 0, 1, 0},
	     {1, 0, 1, 0, 0, 0, 0, 1, 0},
	     {0, 1, 0, 1, 0, 0, 0, 1, 0},
	     {0, 0, 1, 0, 0, 0, 1, 0, 1},
	     {0, 0, 0, 0, 0, 1, 1, 0, 0},
	     {0, 0, 0, 0, 1, 0, 0, 0, 0},
	     {0, 0, 0, 1, 1, 0, 0, 1, 0},
	     {1, 1, 1, 0, 0, 0, 1, 0, 0},
	     {0, 0, 0, 1, 0, 0, 0, 0, 0}};

	marked = new boolean[adjmat.length];
	queue  = new int[adjmat.length];
	queuePos = -1;

	BreadthFirstTraversal(adjmat, 0);
    }
}