package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.*;

import se.kth.iv1350.pos.integration.Item;


public class Receipt {
    private Date saleDate;
    private LocalTime saleTime;
    private float totalVAT;
    private float totalPriceIncludingVAT;
    private float paid;
    private float change;
    private HashMap<Item, Integer> itemsInFinishedSale;
    
    public Receipt(Date saleDate, LocalTime saleTime, float totalVAT, float totalPriceIncludingVAT, HashMap<Item, Integer> itemsInFinishedSale){
        this.saleDate = saleDate;
        this.saleTime = saleTime;
        this.totalVAT = totalVAT;
        this.totalPriceIncludingVAT = totalPriceIncludingVAT;
        this.paid = paid;
        this.change = change;
        this.itemsInFinishedSale = itemsInFinishedSale;
    }
    
    public Date getSaleDate(){
        return saleDate;
    }
    public LocalTime getSaleTime(){
        return saleTime;
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
    public HashMap<Item, Integer> getItemsInSale(){
        return itemsInFinishedSale;
    }
    
}
