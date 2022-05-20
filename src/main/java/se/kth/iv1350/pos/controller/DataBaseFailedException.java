package se.kth.iv1350.pos.controller;

/**
 * Throws when the controller can't connect to the Inventory System.
 */
public class DataBaseFailedException extends Exception {
    
    /**
     * Creates a new instance
     */
    public DataBaseFailedException(){
        super("Can't connect to external systems. Try again");
    }
    
}
