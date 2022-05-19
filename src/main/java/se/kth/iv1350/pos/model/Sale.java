package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import se.kth.iv1350.pos.dto.ItemDTO;
import se.kth.iv1350.pos.integration.InventorySystemException;

/**
 * Represents a Sale. Containing Sale information and can calculate price of the sale. 
 * 
 */
public class Sale {
    private Date saleDate;
    private float totalPrice;
    private float totalVAT;
    private float totalPriceIncludingVAT;
    private HashMap<ItemDTO, Integer> listOfAllItemsInCurrentSale;
    private int totalQuantityOfItemsInSale;
    private ItemDTO latestAddedItem;
    
    /**
     * Creates a new instance of Sale
     * Sets date and time 
     */
    public Sale(){
        saleDate = new Date();
        listOfAllItemsInCurrentSale =new HashMap<ItemDTO, Integer>();
    }
    
    public Date getSaleDate(){
        return saleDate;
    }
    
    public float getTotalPrice(){
        return totalPrice;
    }
    
    public float getTotalVAT(){
        return totalVAT;
    }
    
    public float getTotalPriceIncludingVAT(){
        return totalPriceIncludingVAT;
    }
    public HashMap<ItemDTO, Integer> getAllItems() {
		return listOfAllItemsInCurrentSale;
	}
    
    public float getChangeToGiveToCostumer(float payment) {
        return payment - totalPriceIncludingVAT;
    }
    
    public int getTotalQuantityOfItemsInSale(){
            return totalQuantityOfItemsInSale;
    }
    
    public ItemDTO getLatestAddedItem(){
        return latestAddedItem;
    }
    
    /**
     *  adds item to the hashmap "listOfAllItemsInCurrentSale. If item already exist value of that key is increased with 1
     *  If item does not exist in current sale the item is added to the hashmap using .put
     * @param item that corresponds to the itemID scanned
     * @param quantity. The quantity of said item to add
     * @throws InventorySystemException if there is a problem with the database
     * @throws ItemNotInSystemException if there is no item with matching item ID
     */
    public void addItemToSale(ItemDTO item, int quantity)throws ItemNotInSystemException, InventorySystemException{
        if(checkIfItemIsInCurrentSale(item)){
            int prevQuantity = listOfAllItemsInCurrentSale.get(item);
            listOfAllItemsInCurrentSale.replace(item, prevQuantity+quantity);
        }
            
        else
            listOfAllItemsInCurrentSale.put(item, quantity);
            
        CalculateTotalIncludingVAT(item, quantity);
        totalQuantityOfItemsInSale += quantity;
        latestAddedItem = item;
    }
    
    /**
     * Method used to check if an item is in the hash map. 
     * @param item to check
     * @return boolean
     */
    private boolean checkIfItemIsInCurrentSale(ItemDTO item){
        for(ItemDTO i : listOfAllItemsInCurrentSale.keySet()){
            if(i.getItemID() == item.getItemID())
                return true; 
        }
        return false;
    }
   
    private void CalculateTotalIncludingVAT(ItemDTO item, int quantity){
        totalPrice += item.getItemPrice()*quantity;
        totalVAT += item.getItemPrice()*item.getItemVAT()*quantity;
        totalPriceIncludingVAT = totalPrice + totalVAT;
    }
}
