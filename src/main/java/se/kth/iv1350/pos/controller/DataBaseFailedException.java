package se.kth.iv1350.pos.controller;

/**
 *
 */
public class DataBaseFailedException extends Exception {
    
    public DataBaseFailedException(){
        super("Can't connect to external systems. Try again");
    }
    
}
