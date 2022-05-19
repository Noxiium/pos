package se.kth.iv1350.pos.model;

/**
 * Thrown when trying to scan an item ID that does
 * not exist in the system.
 */
public class ItemNotInSystemException extends Exception{
    private int itemIDOfItemNotInSystem;
    
    /**
     * Creates a new instance with a error message saying 
     * that an item could not be found in the system and the ID.
     * @param itemID id that can not be added to the sale.
     */
    public ItemNotInSystemException(int itemIDOfItemNotInSystem){
        super("Unable to scan. Item with ID " + 
                itemIDOfItemNotInSystem + 
                " does not exist in system");
        this.itemIDOfItemNotInSystem = itemIDOfItemNotInSystem;
    }
    
    /**
     * @return The id of the item that could not be added to the sale.
     */
    public int getitemIDOfItemNotInSystem(){
        return itemIDOfItemNotInSystem;
    }
}