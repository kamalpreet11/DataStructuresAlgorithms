/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh.utils;

/**
 *
 * @author kapsinator
 */
public class ArraysUtils {

    public static void printArray(int[] input) {
        if (input != null) {
            Logger.log("Array: [");
            for (int i = 0; i < input.length; i++) {
                if (i < input.length - 1) {
                    Logger.log(input[i] + ", ");
                } else {
                    Logger.log(input[i] + "]");
                }
            }
            Logger.br();
        } else {
            Logger.log("Array: null");Logger.br();
        }
    }    
}
