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

public class Layer {
    /**
     * An array of neurons.
     */
    protected Neuron neuron[] = new Neuron[4];

    /**
     * The output of the neurons.
     */
    protected boolean output[] = new boolean[4];

    /**
     * The number of neurons in this layer. And because this is a
     * single layer neural network, this is also the number of
     * neurons in the network.
     */
    protected int neurons;

    /**
     * A constant to multiply against the threshold function.
     * This is not used, and is set to 1.
     */
    public static final double lambda = 1.0;

    /**
     * The constructor. The weight matrix for the neurons must be passed in. 
     * Because this is a single layer network the weight array should always be 
     * perfectly square(i.e. 4x4). These weights are used to initialize the 
     * neurons.
     *
     * @param weights A 2d array that contains the weights between each 
     *        neuron and the other neurons
     */
    Layer(int[][] weights) {        
        neurons = weights[0].length;
        
        neuron = new Neuron[neurons];
        output = new boolean[neurons];
        
        for (int i = 0; i < neurons; i++) {
            neuron[i] = new Neuron(weights[i]);
        }
    }

    /**
     * The threshold method is used to determine if the neural
     * network will fire for a given pattern. This threshold
     * uses the hyperbolic tangent (tanh).
     *
     * @param k The product of the neuron weights and the input pattern.
     * @return Whether to fire or not to fire.
     */
    public boolean threshold(int k) {
        double kk = k * lambda;
        double a = Math.exp(kk);
        double b = Math.exp(-kk);
        double tanh = (a - b) / (a + b);
        
        return (tanh >= 0);
    }

    /**
     * This method is called to actually run the neural network.
     *
     * @param pattern The input pattern to present to the neural network.
     */
    void activation(boolean[] pattern) {
        int i, j;
        
        for (i = 0; i < 4; ++i) {
            neuron[i].activation = neuron[i].act(pattern);
            output[i] = threshold(neuron[i].activation);
        }
    }
}

