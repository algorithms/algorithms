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

public class Neuron {
    /**
     * The weights between this neuron and the other neurons on
     * the layer.
     */
    public int[] weightv;

    /**
     * Activation results for this neuron.
     */
    public int activation;

    /**
     * The constructor. The weights between this neuron and
     * every other neuron(including itself) is passed in as
     * an array. Usually the weight between this neuron and
     * itself is zero.
     *
     * @param in The weight vector.
     */
    public Neuron(int[] in) {
        weightv = in;
    }

    /**
     * This method is called to determine if the neuron would
     * activate, or fire.
     *
     * @param  x Neuron input
     * @return If the neuron would activate, or fire
     */
    public int act(boolean[] x) {
        int i;
        int a = 0;
        
        for (i = 0; i < x.length; i++) {
            if (x[i]) {
                a += weightv[i];
            }
        }
        
        return a;
    }
}

