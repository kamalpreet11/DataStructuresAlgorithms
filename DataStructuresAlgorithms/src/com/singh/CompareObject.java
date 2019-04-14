/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh;

/**
 *
 * @author kapsinator
 */
public interface CompareObject<T, O> {
    /**
     * Compares two objects
     * 
     * @param object1
     * @param object2
     * @return <pre>
     *  -1 if object1 < object2
     *  0 if object1 == object2
     *  1 if object1 > object2</pre>
     */
    public int compare(T object1, O object2);
}
