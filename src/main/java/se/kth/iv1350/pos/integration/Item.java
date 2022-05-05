package se.kth.iv1350.pos.integration;

import javax.sound.midi.SysexMessage;

public class Item {
    private int itemID;
    private String nameOfItem;
    private float priceOfItem;
    private float VATOfItem;
    
    public Item(int itemID, String nameOfItem, float priceOfItem, float VATOfItem) {
        this.itemID = itemID;
        this.nameOfItem = nameOfItem;
        this.priceOfItem = priceOfItem;
        this.VATOfItem = VATOfItem;
    }
    
    public int getItemID(){return itemID;}
    public String getNameOfItem(){return nameOfItem;}
    public float getItemPrice(){return priceOfItem;}
    public float getItemVAT(){return VATOfItem;}
   
}
