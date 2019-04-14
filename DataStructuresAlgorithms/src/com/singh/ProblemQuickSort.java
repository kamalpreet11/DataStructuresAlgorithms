/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh;

import com.singh.algorithms.QuickSort;
import com.singh.utils.ArraysUtils;
import com.singh.utils.Logger;
import java.util.Arrays;

/**
 *
 * @author kapsinator
 */
public class ProblemQuickSort extends Problem {

    public static final String NAME = "quicksort";
    
    public ProblemQuickSort() {
        super(NAME, "Algorithm to sort an array");
    }

    @Override
    public boolean onExecute(boolean verbose) throws Exception {
        boolean result = (new QuickSortTest("QuickSort Test case 1", new Integer[]{44, 33, 11, 55, 77, 90, 40, 60, 99, 22, 88, 66, 100, 1, 5, 17, 39},
        new Integer[]{1, 5, 11, 17, 22, 33, 39, 40, 44, 55, 60, 66, 77, 88, 90, 99, 100}, verbose)).run();
        
        result &= (new QuickSortTest("QuickSort Test case 2", new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, verbose)).run();
        
        result &= (new QuickSortTest("QuickSort Test case 3", new Integer[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, verbose)).run();
        
        result &= (new QuickSortTest("QuickSort Test case 4", null, null, verbose)).run();
        
        result &= (new QuickSortTest("QuickSort Test case 5", new Integer[1], new Integer[1], verbose)).run();
        
        result &= (new QuickSortTest("QuickSort Test case 6", new Integer[]{100}, new Integer[]{100}, verbose)).run();
        
        return result;
    }
    
    private static final class QuickSortTest extends TestCase<Integer[], Integer[]> {

        public QuickSortTest(String testCaseLabel, Integer[] input, Integer[] output, boolean verbose) {
            super(testCaseLabel, input, output, verbose);
        }

        @Override
        public boolean run() throws Exception {
            if (verbose) { Logger.log("Input  ");ArraysUtils.printArray(input); }
            input = (new QuickSort<Integer>()).sort(input, new CompareObject<Integer, Integer>() {
                @Override
                public int compare(Integer object1, Integer object2) {
                    if (object1 < object2) {
                        return -1;
                    } else if (object1 > object2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            if(!Arrays.equals(input, output)) {
                if (verbose) { Logger.log("Sorted ");ArraysUtils.printArray(input); }
                throw new Exception("Test case failed: " + testCaseLabel);
            }
            if (verbose) { Logger.log("Sorted ");ArraysUtils.printArray(input); }
            return true;
        }
    }
}
