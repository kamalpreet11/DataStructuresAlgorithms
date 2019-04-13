/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh.algorithms;

import java.util.Stack;

/**
 *
 * @author kapsinator
 */
public class QuickSort {

    public int[] qSort(int[] input) {
        Stack<Integer> stack = new Stack<>();
        if (input != null && input.length > 1) {
            stack.add(0);
            stack.add(input.length - 1);
            while (!stack.isEmpty()) {
                int right = stack.pop();
                int left = stack.pop();
                int location = left;
                input = sort(input, left, right, location, stack);
            }
        }
        return input;
    }
    
    private int[] sort(int[] input, int left, int right, int location, Stack<Integer> stack) {
        int origRight = right;
        int origLeft = left;
        
        if (left < 0 || right < 0) {
            return input;
        }
        
        if (left >= right) {
            return input;
        }
        
        while (left != right) {
            while (input[location] <= input[right] && location != right) {
                right--;
            }
            if (location == right) {
                break;
            }

            if (input[location] > input[right]) {
                int temp = input[location];
                input[location] = input[right];
                input[right] = temp;
            }

            location = right;

            while (location != left && input[left] <= input[location]) {
                left++;
            }

            if (location == left) {
                 break;
            }

            if (input[left] > input[location]) {
                int temp = input[location];
                input[location] = input[left];
                input[left] = temp;
            }
            location = left;
        }
        stack.add(origLeft);
        stack.add(location - 1);
        stack.add(location + 1);
        stack.add(origRight);
        return input;
    }    
}
