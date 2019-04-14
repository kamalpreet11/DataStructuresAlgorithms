/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh;

import com.singh.algorithms.BubbleSort;
import com.singh.utils.ArraysUtils;
import com.singh.utils.Logger;
import java.util.Arrays;

/**
 *
 * @author kapsinator
 */
public class ProblemBubbleSort extends Problem {

    public static final String NAME = "bubblesort";
    
    public ProblemBubbleSort() {
        super(NAME, "Algorithm to sort an array");
    }

    @Override
    public boolean onExecute(boolean verbose) throws Exception {
        boolean result = (new BubbleSortTest("BubbleSort Test case 1", new int[]{44, 33, 11, 55, 77, 90, 40, 60, 99, 22, 88, 66, 100, 1, 5, 17, 39},
        new int[]{1, 5, 11, 17, 22, 33, 39, 40, 44, 55, 60, 66, 77, 88, 90, 99, 100}, verbose)).run();
        
        result &= (new BubbleSortTest("BubbleSort Test case 2", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, verbose)).run();
        
        result &= (new BubbleSortTest("BubbleSort Test case 3", new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, verbose)).run();
        
        result &= (new BubbleSortTest("BubbleSort Test case 4", null, null, verbose)).run();
        
        result &= (new BubbleSortTest("BubbleSort Test case 5", new int[1], new int[1], verbose)).run();
        
        result &= (new BubbleSortTest("BubbleSort Test case 6", new int[]{100}, new int[]{100}, verbose)).run();
        
        return result;
    }
    
    private static final class BubbleSortTest extends TestCase<int[], int[]> {

        public BubbleSortTest(String testCaseLabel, int[] input, int[] output, boolean verbose) {
            super(testCaseLabel, input, output, verbose);
        }

        @Override
        public boolean run() throws Exception {
            if (verbose) { Logger.log("Input  ");ArraysUtils.printArray(input); }
            input = (new BubbleSort()).sort(input);
            if(!Arrays.equals(input, output)) {
                if (verbose) { Logger.log("Sorted ");ArraysUtils.printArray(input); }
                throw new Exception("Test case failed: " + testCaseLabel);
            }
            if (verbose) { Logger.log("Sorted ");ArraysUtils.printArray(input); }
            return true;
        }
    }
}
