/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh;

import com.singh.utils.CliArgs;
import com.singh.utils.Logger;
import java.util.HashMap;

/**
 *
 * @author kapsinator
 */
public class datastructuresalgorithms {

    private static final HashMap<String, Problem> problems = new HashMap<>();
    static {
        problems.put(ProblemQuickSort.NAME, new ProblemQuickSort());
        problems.put(ProblemBubbleSort.NAME, new ProblemBubbleSort());
        problems.put(ProblemBinaryTree.NAME, new ProblemBinaryTree());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CliArgs cliArgs = new CliArgs(args);  
        
        String problemTag = cliArgs.switchValue("-r");
        if (problemTag != null) {
            System.out.println("Executing problem: " + problemTag);
            Problem problem = problems.get(problemTag);
            if (problem != null) {
                problem.execute(cliArgs.switchPresent("-v"));
            } else {
                printAllProblems();
            }
        } else {
            printAllProblems();
        }
    }
    
    private static void printAllProblems() {
        Logger.br();
        Logger.logn("Available Problems: ");
        for (String key : problems.keySet()) {
            Problem problem = problems.get(key);
            Logger.log(problem.type);Logger.log(" - ");Logger.logn(problem.message);
        }
        Logger.br();
        Logger.logn("Run with args: -r <name of problem | all>");
        Logger.br();
    }
    
}
