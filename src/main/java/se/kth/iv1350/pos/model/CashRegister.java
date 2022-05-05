package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.Item;

public class CashRegister {
    private float amountInRegister;
    
    public CashRegister(){
        this.amountInRegister = 1000;
    }
    
    /**
     * updates the amount in the register
     * @param total 
     */
    public void updateAmountInRegister(float total){
        amountInRegister =+ total;
    }
    
    /**
     * simulates printing sale information on receipt. Now it's just printing in terminal
     * @param receipt 
     */
    public void print (Receipt receipt){
        System.out.println("Receipt");
        System.out.println(receipt.getSaleDate() + " " + receipt.getSaleTime());
        for(Item item : receipt.getItemsInSale().keySet()){
            System.out.println(item.getNameOfItem() + " " + receipt.getItemsInSale().get(item) + 
            "*" + item.getItemPrice() + " kr");
        }
        System.out.println("Total" + " " + receipt.getTotalPriceIncludingVAT());
        System.out.println("VAT" + " " + receipt.getTotalVAT());
        
        
    }
}
