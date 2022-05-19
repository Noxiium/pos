package se.kth.iv1350.pos.integration;

/**
 * Thrown when the database can not be called.
 */
public class InventorySystemException extends RuntimeException {
    
    /**
     * Creates a new instance of the condition described
     * in the error message.
     * @param errorMessage a message saying what went wrong
     */
    public InventorySystemException(String errorMessage) {
        super(errorMessage);
    }
    
}
