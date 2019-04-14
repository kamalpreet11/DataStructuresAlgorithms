/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh.algorithms;

/**
 *
 * @author kapsinator
 */
public class BubbleSort {

    public int[] sort(int[] input) {
        if (input != null) {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input.length - i - 1; j++) {
                    if (input[j] > input[j + 1]) {
                        int temp = input[j];
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
