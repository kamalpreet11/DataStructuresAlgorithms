/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh.algorithms;

import com.singh.CompareObject;

/**
 *
 * @author kapsinator
 */
public class BubbleSort<T> {

    public T[] sort(T[] input, CompareObject<T, T> compare) {
        if (input != null) {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input.length - i - 1; j++) {
                    if (compare.compare(input[j], input[j + 1]) > 0) {
                        T temp = input[j];
                        input[j] = input[j + 1];
                        input[j + 1] = temp;
                    }
                }
            }
            return input;
        } else {
            return input;
        }
    }
}
