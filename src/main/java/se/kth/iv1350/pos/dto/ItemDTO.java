package se.kth.iv1350.pos.dto;

/**
 * Represents an item.
 */
public class ItemDTO {
    private int itemID;
    private String nameOfItem;
    private float priceOfItem;
    private float VATOfItem;
    
    public int getItemID(){
        return itemID;
    }
    
    public String getNameOfItem(){
        return nameOfItem;
    }
    
    public float getItemPrice(){
        return priceOfItem;
    }
    
    public float getItemVAT(){
        return VATOfItem;
    }
    
    /**
     * Sets the given information to the object
     * @param itemID Number/barcode for the item
     * @param nameOfItem Name of the item
     * @param priceOfItem Price of the item
     * @param VATOfItem VAT rate of the item
     */
    public ItemDTO(int itemID, String nameOfItem, float priceOfItem, float VATOfItem) {
        this.itemID = itemID;
        this.nameOfItem = nameOfItem;
        this.priceOfItem = priceOfItem;
        this.VATOfItem = VATOfItem;
    }   
}
