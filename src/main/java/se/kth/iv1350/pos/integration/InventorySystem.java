package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.ItemNotInSystemException;
import se.kth.iv1350.pos.dto.ItemDTO;
import java.util.HashMap;

/**
 * Calls to the external inventory system.
 * In this program the system is hardcoded.
 * This class represents the inventory in the store. A HashMap contains
 * what items the store has and how many is in store
 *  
 */
public class InventorySystem {
    private HashMap<ItemDTO, Integer> inventory;
    
    /**
     * Creates an instance. Fills up the inventory with "fake" items to
     * simulate the program.
     */
    public InventorySystem() {
		this.inventory = new HashMap<ItemDTO, Integer>();
		fillInventory();
    }
	
    /**
     * Check if the item is in the system and adds it to sale
     * @param itemID 
     * @return the item corresponding to correct itemID
     * @throws InventorySystemException if there is a problem with the database
     * @throws ItemNotInSystemException if there is no item with matching item ID
     */
    public ItemDTO returnItemToSale(int itemID) throws ItemNotInSystemException, InventorySystemException {
       if (itemID == 100){
           throw new InventorySystemException("ERROR ERROR! SELF EXPLODE (Can't reach DataBase)");
       }
       
       for(ItemDTO item : inventory.keySet()) 
           if (item.getItemID()==itemID) 
               return item;
       throw new ItemNotInSystemException(itemID);
    }
    
    private void fillInventory(){
        addItemToInventory(1, "Choklad", 10, 0.25f, 10);
        addItemToInventory(2, "Kaffe", 25, 0.25f, 10);
        addItemToInventory(3, "Cola", 10, 0.25f, 10);
        addItemToInventory(4, "Melon", 20, 0.25f, 10);
    }
    
    /**
     * Adds a new item to the placeholder inventory.
     * @param itemID
     * @param name
     * @param price
     * @param VAT
     * @param quantity 
     */
    public void addItemToInventory(int itemID, String name, float price, float VAT, int quantity) {
		inventory.put(new ItemDTO(itemID, name, price, VAT), quantity);
	}
    
    /**
     * Adds a new item to the placeholder inventory.
     * @param item
     * @param quantity 
     */
    public void addItemToInventory(ItemDTO item, int quantity){
        inventory.put(item, quantity);
    }
    
    /**
     * Updates the inventory after a finished Sale.
     * @param soldItemsInFinishedSale 
     */
    public void updateInventory(HashMap<ItemDTO, Integer> soldItemsInFinishedSale){
        for(ItemDTO soldItem : soldItemsInFinishedSale.keySet())
        {
            for(ItemDTO invItem : inventory.keySet()) {
                if(soldItem.getItemID()==invItem.getItemID())
                    inventory.replace(invItem, (inventory.get(invItem)-soldItemsInFinishedSale.get(soldItem)));
                
                inventory.containsKey(soldItem);
            }
        }
    }
    
    /**
     * Returns an integer of how many of the item is in storage.
     * @param itemID
     * @return the quantity of item in storage
     */
    public int getInventoryQuantity(int itemID){
        for(ItemDTO item : inventory.keySet()) {
           if (item.getItemID()==itemID) return inventory.get(item);
		}
       return 0;
    }
}
