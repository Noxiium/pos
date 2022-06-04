package se.kth.iv1350.pos.view;

import java.util.Scanner;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.controller.DataBaseFailedException;
import se.kth.iv1350.pos.dto.ItemDTO;
import se.kth.iv1350.pos.model.ItemNotInSystemException;

/**
 * A placeholder for the real view. 
 * Runs a fake Execution simulating the view of the program.
 * 
 */
public class View {
    private Controller contr;
    private TotalRevenueView totalRevenueView;
    private TotalRevenueFileOutput totalRevenueFileOutput;
    
    /**
     * Creates a new instance.
     * 
     * @param contr Controller that the view uses.
     */
    public View(Controller contr){
        this.contr = contr;
        totalRevenueView = new TotalRevenueView();
        totalRevenueFileOutput = new TotalRevenueFileOutput();
        contr.addRegisterRevenueObserver(totalRevenueView);
        contr.addRegisterRevenueObserver(totalRevenueFileOutput);
    }
    
    /**
     * Simulates the view of a Sale with print outs.
     * 
     */
    public void runFakeExecution(){
        contr.startNewSale();
        System.out.println("New Sale");
        addAndprintAddedItem(1,2);
        addAndprintAddedItem(100,1);
        addAndprintAddedItem(2,3);
        addAndprintAddedItem(77,2);
        addAndprintAddedItem(3,1);
        addAndprintAddedItem(4,2);
        contr.endSale(200);
        
        contr.startNewSale();
        System.out.println("New Sale");
        addAndprintAddedItem(1,1);
        contr.endSale(100);
        
        
    }
    
    private void addAndprintAddedItem(int itemID, int quantity){
        try {
        ItemDTO item = contr.addItemToSale(itemID, quantity);
        System.out.println("Item added: " + item.getNameOfItem() + " " + quantity + " * " + item.getItemPrice() + "kr");
        System.out.println("Total: " + contr.getTotalPriceOfSale()+ "kr");
        }
        catch(ItemNotInSystemException | DataBaseFailedException DBExc) {
            System.out.println("Failed to scan item. ERROR: " + DBExc.getMessage());
        }
    }
    
    
}
