/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh;

import com.singh.ProblemBinaryTree.BinaryTreeTestCase.TraversalType;
import com.singh.datastructures.BinaryTree;
import com.singh.datastructures.TreeNode;
import com.singh.utils.ArraysUtils;
import com.singh.utils.Logger;
import java.util.ArrayList;

/**
 *
 * @author kapsinator
 */
public class ProblemBinaryTree extends Problem {
    
    public static final String NAME = "binarytree";

    public ProblemBinaryTree() {
        super(NAME, "Simple Binary tree demo");
    }

    @Override
    public boolean onExecute(boolean verbose) throws Exception {
        BinaryTree<Integer> bTree = new BinaryTree<>(new CompareObject<Integer, Integer>() {
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
            bTree.add(45)
                .add(22)
                .add(11)
                .add(30)
                .add(25)
                .add(77)
                .add(66)
                .add(90)
                .add(88)
                .add(91)
                .add(80);
            boolean result = (new BinaryTreeTestCase("PreOrder Tree Traversal", bTree, new Integer[]{45, 22, 11, 30, 25, 77, 66, 90, 88, 80, 91}, verbose, TraversalType.PRE_ORDER)).run();
            result &= (new BinaryTreeTestCase("InOrder Tree Traversal", bTree, new Integer[]{11, 22, 25, 30, 45, 66, 77, 80, 88, 90, 91}, verbose, TraversalType.IN_ORDER)).run();
            result &= (new BinaryTreeTestCase("PostOrder Tree Traversal", bTree, new Integer[]{11, 25, 30, 22, 66, 80, 88, 91, 90, 77, 45}, verbose, TraversalType.POST_ORDER)).run();
        return result;
    }
    
    public static final class BinaryTreeTestCase extends TestCase<BinaryTree, Integer[]> {
        
        public static enum TraversalType {
            PRE_ORDER,
            IN_ORDER,
            POST_ORDER
        }
        
        TraversalType traversalType;

        public BinaryTreeTestCase(String testCaseLabel, BinaryTree input, Integer[] output, boolean verbose, TraversalType traversalType) {
            super(testCaseLabel, input, output, verbose);
            this.traversalType = traversalType;
        }

        @Override
        public boolean run() throws Exception {
            ArrayList<TreeNode> orderTree = new ArrayList();
            
            switch (traversalType) {
                case PRE_ORDER:
                    input.toPreOrder(input.getRoot(), orderTree);
                    break;
                case IN_ORDER:
                    input.toInOrder(input.getRoot(), orderTree);
                    break;
                case POST_ORDER:
                    input.toPostOrder(input.getRoot(), orderTree);
                    break;
            }
            
            
            Integer[] results = new Integer[orderTree.size()];
            for (int i = 0; i < orderTree.size(); i++) {
                results[i] = (Integer) orderTree.get(i).getData();
            }
            
            if (output.length != results.length) {
                if (verbose) { Logger.log("Sorted ");ArraysUtils.printArray(results); }
                throw new Exception("Test case failed: " + testCaseLabel);
            }
            for (int i = 0; i < orderTree.size(); i++) {
                if (output[i] != results[i]) {
                    if (verbose) { Logger.log("Sorted ");ArraysUtils.printArray(results); }
                    throw new Exception("Test case failed: " + testCaseLabel);
                }
            }
            return true;
        }        
    }
}