/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh.datastructures;

/**
 *
 * @author kapsinator
 */
public class TreeNode<T> {
 
    protected T data = null;
    
    protected TreeNode<T> left = null;
    
    protected TreeNode<T> right = null;
    
    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
