package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.*;

import se.kth.iv1350.pos.integration.Item;

/**
 * One single sale. 
 * 
 */
public class Sale {
    private Date saleDate;
    private LocalTime saleTime;
    private float totalPrice;
    private float totalVAT;
    private float totalPriceIncludingVAT;
    
    private HashMap<Item, Integer> listOfAllItemsInCurrentSale;
    
    /**
     * Creates a new instance, sets date and time
     * sets totalPrice and VAT to zero. 
     * clears the hashmap. (hashmap key=item, values = quantity)
     */
    public Sale(){
        saleDate = new Date();
        saleTime = LocalTime.now();
        totalPrice = 0;
        totalVAT = 0;
        totalPriceIncludingVAT = 0;
        listOfAllItemsInCurrentSale =new HashMap<Item, Integer>();
    }
    /**
     *  adds item to the hashmap "listOfAllItemsInCurrentSale. If item already exist value of that key is increased with 1
     *  If item does not exist in current sale the item is added to the hashmap using .put
     *  Overloaded method that also has quantity as parameter
     *  @param item that corresponds to the itemID scanned
     */
    public void addItemToSale(Item item){
        if(checkIfItemIsInCurrentSale(item)){
            int prevQuantity = listOfAllItemsInCurrentSale.get(item);
            listOfAllItemsInCurrentSale.replace(item, prevQuantity+1);
        }
            
        else
            listOfAllItemsInCurrentSale.put(item, 1);  
        
        CalculateTotalIncludingVAT();
    }
    /**
     * Overloaded addItemToSale
     * @param item that corresponds to the itemID scanned
     * @param quantity, if the user wants to add multiple of the same item
     */
    public void addItemToSale(Item item, int quantity){
        if(checkIfItemIsInCurrentSale(item)){
            int prevQuantity = listOfAllItemsInCurrentSale.get(item);
            listOfAllItemsInCurrentSale.replace(item, prevQuantity+quantity);
        }
            
        else
            listOfAllItemsInCurrentSale.put(item, quantity);
            
        CalculateTotalIncludingVAT();
    }
    
    /**
     * Method used to check if an item is in the hash map. returns true if true.
     * @param item to check
     * @return boolean
     */
    public boolean checkIfItemIsInCurrentSale(Item item){
        for(Item i : listOfAllItemsInCurrentSale.keySet()){
            if(i.getItemID() == item.getItemID())
                return true; 
        }
        return false;
    }
    

    
    private void CalculateTotalIncludingVAT(){
        //reset
        totalPrice = 0;
        totalVAT = 0;
        totalPriceIncludingVAT = 0;
        for(Item item : listOfAllItemsInCurrentSale.keySet()){
            totalPrice += item.getItemPrice()*listOfAllItemsInCurrentSale.get(item);
            totalVAT += item.getItemPrice()*item.getItemVAT()*listOfAllItemsInCurrentSale.get(item);
        }
        totalPriceIncludingVAT = totalPrice + totalVAT;
    }
    
    public float getTotalPrice(){return totalPrice;}
    public float getTotalVAT(){return totalVAT;}
    public float getTotalPriceIncludingVAT(){return totalPriceIncludingVAT;}
    public HashMap<Item, Integer> getAllItems() {
		return listOfAllItemsInCurrentSale;
	}
    
    public Receipt getReceipt(){
        return new Receipt(saleDate, saleTime, totalVAT, totalPriceIncludingVAT, listOfAllItemsInCurrentSale);
            //saleDTO as paramater. from controller? add paid and change
    }
    
    
    
}
