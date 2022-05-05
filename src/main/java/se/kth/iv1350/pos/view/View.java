package se.kth.iv1350.pos.view;

import java.util.Scanner;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.Item;

/**
 * A placeholder for the real view. 
 * Print outs will be a temp for the view
 */
public class View {
    private Controller contr;
    
    /**
     * Creates a new instance
     * 
     * @param contr
     */
    public View(Controller contr){
        this.contr = contr;
    }
    
    
    
    /**
     * runFakeExecution simulates the 
     * view with printOuts in the terminal
     */
    public void runFakeExecution(){
        contr.startNewSale();
        System.out.println("New Sale");
        addAndprintAddedItem(1,2);
        addAndprintAddedItem(4);
        addAndprintAddedItem(2,2);
        contr.endSale(100);
        System.out.println();
    }
    
    private void addAndprintAddedItem(int itemID, int quantity){
        Item item = contr.addItemToSale(itemID, quantity);
        System.out.println("Item added: " + item.getNameOfItem() + " " + item.getItemPrice() + "kr");
        System.out.println("Total: " + contr.getTotalPriceOfSale()+ "kr");
    }
    
    private void addAndprintAddedItem(int itemID){
        Item item = contr.addItemToSale(itemID);
        System.out.println("Item added " + item.getNameOfItem() + " " + item.getItemPrice() + "kr");
        System.out.println("Total: " + contr.getTotalPriceOfSale() + "kr");
    }
    
}
