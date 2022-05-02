package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.Date;

/**
 * One single sale. 
 * 
 */
public class Sale {
    private Date saleDate;
    private LocalTime saleTime;
    private float totalPrice;
    private float totalVAT;
    private AllItemsInCurrentSale itemsInSale;
    private  Receipt receipt;
    
    /**
     * Creates a new instance, sets date and time
     * sets totalPrice and VAT to zero
     */
    public Sale(){
        saleDate = new Date();
        saleTime = LocalTime.now();
        totalPrice = 0;
        totalVAT = 0;
        receipt = new Receipt();
        
        
        
    }
    
}
