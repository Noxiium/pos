package se.kth.iv1350.pos.view;

import java.util.Scanner;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dto.ItemDTO;

/**
 * A placeholder for the real view. 
 * Runs a fake Execution simulating the view of the program.
 * 
 */
public class View {
    private Controller contr;
    
    /**
     * Creates a new instance. Saves Controller.
     * 
     * @param contr Controller that the view uses.
     */
    public View(Controller contr){
        this.contr = contr;
    }
    
    /**
     * Simulates the view of a Sale with print outs.
     * 
     */
    public void runFakeExecution(){
        contr.startNewSale();
        System.out.println("New Sale");
        addAndprintAddedItem(1,2);
        addAndprintAddedItem(4,1);
        addAndprintAddedItem(2,2);
        contr.endSale(200);
        
        contr.startNewSale();
        System.out.println("New Sale");
        addAndprintAddedItem(1,1);
        contr.endSale(100);
        
        
    }
    
    private void addAndprintAddedItem(int itemID, int quantity){
        ItemDTO item = contr.addItemToSale(itemID, quantity);
        System.out.println("Item added: " + item.getNameOfItem() + " " + item.getItemPrice() + "kr");
        System.out.println("Total: " + contr.getTotalPriceOfSale()+ "kr");
    }
    
    
}
