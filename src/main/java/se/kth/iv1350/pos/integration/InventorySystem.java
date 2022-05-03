package se.kth.iv1350.pos.integration;

import java.util.HashMap;

/**
 *  This class represents the inventory in the store. A HashMap contains
 *  what items the store has and how many is in store
 *  
 * 
 */
public class InventorySystem {
    private HashMap<Item, Integer> inventory;
    
    public InventorySystem(HashMap<Item, Integer> inventory) {
		this.inventory = inventory;
	}
    
    public InventorySystem() {
		this.inventory = new HashMap<Item, Integer>();
		fillInventory();
    }
	
    
    /**
     * Check if the item is in the system and adds it to sale
     * @param itemID 
     * @return the item corresponding to correct itemID
     */
    public Item returnItemToSale(int itemID){
       for(Item item : inventory.keySet()) {
           if (item.getItemID()==itemID) return item;
		}
       return null;
    }
    
    /**
     * fills up the inventory with items. 
     * this is only for testing
     */
    private void fillInventory(){
        addItemToInventory(1, "Choklad", 10, 0.25f, 10);
        addItemToInventory(2, "Kaffe", 25, 0.25f, 10);
        addItemToInventory(3, "Cola", 10, 0.25f, 10);
        addItemToInventory(4, "Melon", 20, 0.25f, 10);
    }
    /**
     * adds item and quantity into the hashMap inventory. 
     * this is only for testing
     * 
     */
    public void addItemToInventory(int itemID, String name, float price, float VAT, int quantity) {
		inventory.put(new Item(itemID, name, price, VAT), quantity);
	}
    
    public void addItemToInventory(Item item, int quantity){
        inventory.put(item, quantity);
    }
    
    
    
}
