/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singh;

import com.singh.utils.Logger;

/**
 *
 * @author kapsinator
 */
public abstract class Problem {
    
    protected final String type;
    
    protected final String message;

    public Problem(String type, String message) {
        this.type = type;
        this.message = message;
    }
    
    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
    
    public final boolean execute() {        
        Logger.br();
        Logger.log("Executing ");Logger.log(type);Logger.log(" - ");Logger.logn(message);
        boolean result = true;
        try {
            result = onExecute();
            Logger.log("Finished Successfully: ");Logger.logn(type);
        } catch (Exception e) {
            Logger.log("Did not complete: ");Logger.logn(type);
            Logger.log("Failed with error: ");Logger.logn(e.getMessage());
        }        
        Logger.br();
        return result;
    }
    
    public abstract boolean onExecute() throws Exception;
}
