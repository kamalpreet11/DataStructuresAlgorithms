/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh.datastructures;

import com.singh.CompareObject;
import java.util.ArrayList;

/**
 *
 * @author kapsinator
 */
public class BinaryTree<T> {
    
    protected TreeNode<T> root;
    
    protected CompareObject<T, T> compare;

    public BinaryTree(CompareObject<T, T> compare) {
        this.compare = compare;
    }

    public TreeNode<T> getRoot() {
        return root;
    }
            
    public BinaryTree add(T data) {
        if (root == null) {
            root = new TreeNode<>(data);
        } else {
            TreeNode<T> iterator = root;
            while(iterator != null) {
                if (compare.compare(iterator.data, data) > 0) {
                    if (iterator.left == null) {
                        iterator.left = new TreeNode<>(data);
                        iterator = iterator.left;
                    }
                    iterator = iterator.left;
                } else {
                    if (iterator.right == null) {
                        iterator.right = new TreeNode<>(data);
                        iterator = iterator.right;
                    }
                    iterator = iterator.right;
                }
            }
        }
        return this;
    }
    
    public void toPreOrder(TreeNode node, ArrayList<TreeNode> out) {
        if (node != null) {
            out.add(node);
            toPreOrder(node.left, out);
            toPreOrder(node.right, out);
        }
    }
    
    public void toInOrder(TreeNode node, ArrayList<TreeNode> out) {
        if (node != null) {
            toInOrder(node.left, out);
            out.add(node);
            toInOrder(node.right, out);
        }
    }
    
    public void toPostOrder(TreeNode node, ArrayList<TreeNode> out) {
        if (node != null) {
            toPostOrder(node.left, out);
            toPostOrder(node.right, out);
            out.add(node);
        }
    }
}
