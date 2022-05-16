package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.Receipt;
import se.kth.iv1350.pos.dto.ItemDTO;

/**
 * Represent the register at a POS. It contains cash and a printer.
 * The class holds information about how much cash is in the register.
 */
public class Register {
    private float amountInRegister;
    
    /**
     * Creates an instance. Sets the amount to 1000.
     */
    public Register(){
        amountInRegister = 1000;
    }
    
    public float getAmountInRegister(){
        return amountInRegister;
    }
    
    /**
     * updates the amount present in the register after a finished sale.
     * @param total The total amount of a finished sale.
     */
    public void updateAmountInRegister(float total){
        amountInRegister += total;
    }
    
    /**
     * simulates printing sale information on receipt. Now it's just printing in terminal
     * @param receipt 
     */
    public void printReceipt (Receipt receipt, float changeToGiveToCustomer, float payment){
        System.out.println();
        System.out.println("##### Receipt #####");
        System.out.println(receipt.getSaleDate());
        for(ItemDTO item : receipt.getItemsInSale().keySet()){
            System.out.println(item.getNameOfItem() + " " + receipt.getItemsInSale().get(item) + 
            "*" + item.getItemPrice() + " kr");
        }
        System.out.println("Total" + " " + receipt.getTotalPriceIncludingVAT() + " kr");
        System.out.println("VAT" + " " + receipt.getTotalVAT()+ " kr");
        System.out.println("Amount Paid: " + payment + " kr");
        System.out.println("Change: " + changeToGiveToCustomer + " kr");
        System.out.println("##########################");
       
    }
}
