package se.kth.iv1350.pos.dto;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import se.kth.iv1350.pos.dto.ItemDTO;
import se.kth.iv1350.pos.model.Sale;

/**
 * Represents a receipt The information in receipt can be printed from the class Register.
 * The Receipt class gets its information from the class Sale.
 */
public class Receipt {
    private Date saleDate;
    private float totalVAT;
    private float totalPriceIncludingVAT;
    private float paid;
    private float change;
    private HashMap<ItemDTO, Integer> itemsInFinishedSale;
    
    /**
     * Creates a receipt. 
     * @param endedSale Sale that the receipt proves.
     */
    public Receipt(Sale endedSale){
        this.saleDate = endedSale.getSaleDate();
        this.totalVAT = endedSale.getTotalVAT();
        this.totalPriceIncludingVAT = endedSale.getTotalPriceIncludingVAT();
        this.paid = paid;
        this.change = change;
        this.itemsInFinishedSale = endedSale.getAllItems();
    }
    
    public Date getSaleDate(){
        return saleDate;
    }

    public float getTotalVAT(){
        return totalVAT ;
    }
    
    public float getTotalPriceIncludingVAT(){
        return totalPriceIncludingVAT ;
    }
    
    public float getPaid(){
        return paid ;
    }
    
    public float getChange(){
        return change;
    }
    
    public HashMap<ItemDTO, Integer> getItemsInSale(){
        return itemsInFinishedSale;
    }
    
}