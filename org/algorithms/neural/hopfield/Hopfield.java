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

package algorithms.neural.hopfield;

/**
 * This is an example that implements a Hopfield neural network. This example 
 * network contains four fully connected neurons. 
 */
public class Hopfield {

    /**
     * The number of neurons in this neural network.
     */
    public static final int NETWORK_SIZE = 4;
    
    /**
    * The weight matrix for the four fully connected neurons.
    */
    int[][] matrix = new int[NETWORK_SIZE][NETWORK_SIZE];

    
    /**
    * The input pattern, used to either train or run the neural network. When 
    * the network is being trained, this is the training data. When the neural 
    * network is to be ran this is the input pattern.
    */
    int[] input = new int[NETWORK_SIZE];
    
    /**
    * The output from each of the four neurons.
    */
    int[] output = new int[NETWORK_SIZE];



    public Hopfield() {
        super();

        for (int row = 0; row < NETWORK_SIZE; ++row) {
            for (int col = 0; col < NETWORK_SIZE; ++col) {
                matrix[row][col] =0;
            }
        }
    }

    /**
     * Called when the neural network is to be ran against the input.
     */
    protected void run() {
        boolean[] pattern = new boolean[NETWORK_SIZE];
        int[][]   wt      = new int[NETWORK_SIZE][NETWORK_SIZE];
        
        for (int row = 0; row < NETWORK_SIZE; ++row) {
            for (int col = 0; col < NETWORK_SIZE; ++col) {
                wt[row][col] = matrix[row][col];
            }
        }
        
        for (int row = 0; row < NETWORK_SIZE; ++row) {
            int i = input[row];
            
            if (i == 0) {
                pattern[row] = false;
            } else {
                pattern[row] = true;
            }
        }
        
        Layer net = new Layer(wt);
        net.activation(pattern);
        
        for (int row = 0; row < NETWORK_SIZE; ++row) {
            if (net.output[row]) {
                output[row] = 1;
            } else {
                output[row] = 0;
            }
        }
    }

    /**
     * Called to clear the weight matrix.
     */
    protected void clear() {
        for (int row = 0; row < NETWORK_SIZE; ++row) {
            for (int col = 0; col < NETWORK_SIZE; ++col) {
                matrix[row][col] = 0;
            }
        }
    }

    /**
     * Called to train the weight matrix based on the
     * current input pattern.
     */
    protected void train() {
        int[][] work = new int[NETWORK_SIZE][NETWORK_SIZE];
        int[]   bi   = new int[NETWORK_SIZE];
        
        for (int x = 0; x < NETWORK_SIZE; ++x) {
            if (input[x] == 0) {
                bi[x] = -1;
            } else {
                bi[x] = 1;
            }
        }
        
        for (int row = 0; row < NETWORK_SIZE; ++row) {
            for (int col = 0; col < NETWORK_SIZE; ++col) {
                work[row][col] = bi[row] * bi[col];
            }
        }
        
        for (int x = 0; x < NETWORK_SIZE; ++x) {
            work[x][x] -= 1;
        }
        
        for (int row = 0; row < NETWORK_SIZE; ++row) {
            for (int col = 0; col < NETWORK_SIZE; ++col) {
                int i = matrix[row][col];
                
                matrix[row][col] = (i + work[row][col]);
            }
        }
    }
    
    public static void main(String[] args) {
        Hopfield hopfield = new Hopfield();
        hopfield.input = new int[] {1, 1, 0, 0};
        hopfield.train();
        hopfield.input = new int[] {0, 0, 1, 1};
        hopfield.train();
        
        hopfield.input = new int[] {0, 1, 1, 1};
        hopfield.run();
        
        for (int i : hopfield.output) {
            System.out.print(i);
        }
        System.out.println("");
    }

}
