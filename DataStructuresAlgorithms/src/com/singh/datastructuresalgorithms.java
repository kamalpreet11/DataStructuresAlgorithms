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

    private static HashMap<String, Problem> problems = new HashMap<>();
    static {
        problems.put(ProblemQuickSort.NAME, new ProblemQuickSort());
        problems.put(ProblemBubbleSort.NAME, new ProblemBubbleSort());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CliArgs cliArgs = new CliArgs(args);  
        
        String problem = cliArgs.switchValue("-r");
        if (problem != null) {
            System.out.println("Executing problem: " + problem);
            switch(problem) {
                case ProblemQuickSort.NAME:
                    problems.get(ProblemQuickSort.NAME).execute(cliArgs.switchPresent("-v"));
                    break;
                case ProblemBubbleSort.NAME:
                    problems.get(ProblemBubbleSort.NAME).execute(cliArgs.switchPresent("-v"));
                    break;
                case "all":
                    for (String key : problems.keySet()) {
                        problems.get(key).execute(cliArgs.switchPresent("-v"));
                    }
                    break;
                default:
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
