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
    private  Receipt receipt;
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
        receipt = new Receipt();
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
            listOfAllItemsInCurrentSale.put(item, 1);    
     
    }
    /**
     * Method used to check if an item is in the hashmap. returns true if true.
     */
    public boolean checkIfItemIsInCurrentSale(Item item){
        for(Item i : listOfAllItemsInCurrentSale.keySet()){
            if(i.getItemID() == item.getItemID())
                return true; 
        }
        return false;
    }
    
    
    
}
