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
 * In depth-first traversal, we visit the starting node and then proceed to 
 * follow links through the graph until we reach a dead end. In an undirected 
 * graph, a node is a dead end if all of the nodes adjacent to it have already 
 * been visited. In a directed graph, if a node has no outgoing edges, we also 
 * have a dead end.
 *
 * When we reach a dead end, we back up along our path until we find an 
 * unvisited adjacent node and then continue in that new direction. The process
 * will have completed when we back up to the starting node and all the nodes 
 * adjacent to it have been visited. In illustrating this algorithm and  all 
 * others in this chapter, if presented with a choice of two nodes, we will
 * choose the node with the numerically or alphabetically smaller label. When
 *  this algorithm is implemented, that choice will depend on how the edges of 
 * the graph are stored.
 *
 * @version 0.00 28 Feb 2011
 * @author  Andrey Pudov  
 */
class DepthFirstTraversal {

    private static boolean[] marked;

    /**
     * DepthFirstTraversal(G, v)
     * Visit( v )
     * Mark( v )
     * for every edge vw in G do
     *     if w is not marked then
     *         DepthFirstTraversal(G, w)
     *     end if
     * end for
     *
     * @param g is the graph
     * @param v is the current node
     */
    private static void DepthFirstTraversal(int[][] g, int v) {
	/* visit(v) */
	System.out.print( " -> " + v);
	marked[v] = true;

	for (int w = 0; w < g[v].length; ++w) {
	    if ((g[v][w] == 1) && (!marked[w])) {
		DepthFirstTraversal(g, w);	
	    }
	}	
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

	DepthFirstTraversal(adjmat, 0);
    }
}