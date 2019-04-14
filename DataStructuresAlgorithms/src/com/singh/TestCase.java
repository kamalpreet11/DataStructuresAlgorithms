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
public abstract class TestCase<I,O> {
    protected I input;
    protected O output;
    protected String testCaseLabel;
    protected boolean verbose;
    
    public TestCase(String testCaseLabel, I input, O output) {
        this(testCaseLabel, input, output, false);
    }
    
    public TestCase(String testCaseLabel, I input, O output, boolean verbose) {
        this.testCaseLabel = testCaseLabel;
        this.input = input;
        this.output = output;
        this.verbose = verbose;
    }
    
    public abstract boolean run() throws Exception;
}
