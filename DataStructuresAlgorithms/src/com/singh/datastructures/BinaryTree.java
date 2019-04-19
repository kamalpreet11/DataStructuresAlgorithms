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
    
    public TreeNode contains(T data) {
                
        TreeNode<T> iterator = root;
        
        while (iterator != null && iterator.data != data) {
            if (compare.compare(iterator.data, data) > 0) {
                iterator = iterator.left;
            } else if (compare.compare(iterator.data, data) < 0) {
                iterator = iterator.right;
            }
        }
        
        return iterator;
    }
    
    public TreeNode delete(T data) {
        if (root == null) {
            return null;
        } else {
            TreeNode<T> iterator = root;
            TreeNode<T> parent = null;
            while(iterator != null) {
                if (compare.compare(iterator.data, data) > 0) {
                    parent = iterator;
                    iterator = iterator.left;
                } else if (compare.compare(iterator.data, data) < 0) {
                    parent = iterator;
                    iterator = iterator.right;
                } else {
                    if (iterator.left == null && iterator.right == null) {
                        // this is leaf node
                        if (parent == root) {
                            root = null;
                            break;
                        } else {
                            if (parent.left == iterator) {
                                parent.left = null;
                                break;
                            } else {
                                parent.right = null;
                                break;
                            }
                        }
                    } else {
                        if (iterator.left != null && iterator.right == null) {
                            if (parent == null) {
                                root = iterator.left;
                                break;
                            } else {
                                if (parent.left == iterator) {
                                    parent.left = iterator.left;
                                    break;
                                } else {
                                    parent.right = iterator.left;
                                    break;
                                }
                            }
                        } else if (iterator.left == null && iterator.right != null) {
                            if (parent == null) {
                                root = iterator.right;
                                break;
                            } else {
                                if (parent.left == iterator) {
                                    parent.left = iterator.right;
                                    break;
                                } else {
                                    parent.right = iterator.right;
                                    break;
                                }
                            }
                        } else {
                            // this is hard.
                            TreeNode<T> inorderSuccessor = iterator.right;
                            while (inorderSuccessor.left != null) {
                                inorderSuccessor = inorderSuccessor.left;
                            }
                            delete(inorderSuccessor.getData());
                            
                            if (parent != null) {
                                if (parent.left == iterator) {
                                    parent.left = inorderSuccessor;
                                } else {
                                    parent.right = inorderSuccessor;
                                }
                            } else {
                                root = inorderSuccessor;
                            }
                            inorderSuccessor.left = iterator.left;
                            inorderSuccessor.right = iterator.right;
                            
                            break;
                        }
                    }
                }
            }
            if (iterator != null) {
                iterator.left = null;
                iterator.right = null;
            }
            return iterator;
        }
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
