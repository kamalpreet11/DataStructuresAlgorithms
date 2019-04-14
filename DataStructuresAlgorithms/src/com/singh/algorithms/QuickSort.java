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
public class QuickSort<T> {

    public T[] sort(T[] input, CompareObject<T, T> compare) {
        if (input != null) {
            return sort(input, 0, input.length - 1, 0, compare);
        } else {
            return input;
        }
    }
    
    private T[] sort(T[] input, int left, int right, int location, CompareObject<T, T> compare) {
        int origRight = right;
        int origLeft = left;
        
        if (left < 0 || right < 0) {
            return input;
        }
        
        if (left >= right) {
            return input;
        }
        
        while (left != right) {
            while (compare.compare(input[location], input[right]) < 0 && location != right) {
                right--;
            }
            if (location == right) {
                break;
            }

            if (compare.compare(input[location], input[right]) > 0) {
                T temp = input[location];
                input[location] = input[right];
                input[right] = temp;
            }

            location = right;

            while (location != left && compare.compare(input[left], input[location]) < 0) {
                left++;
            }

            if (location == left) {
                 break;
            }

            if (compare.compare(input[left], input[location]) > 0) {
                T temp = input[location];
                input[location] = input[left];
                input[left] = temp;
            }
            location = left;
        }
        sort(input, origLeft, location - 1, origLeft, compare);
        sort(input, location + 1, origRight, location + 1, compare);
        return input;
    }    
}
