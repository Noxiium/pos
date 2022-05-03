package se.kth.iv1350.pos.view;

import java.util.Scanner;
import se.kth.iv1350.pos.controller.Controller;

/**
 * A placeholder for the real view. 
 * Print outs will be a temp for the view
 */
public class View {
    private Controller contr;
    
    /**
     * Creates a new instance
     * 
     * @param contr Controller for all calls to other layers
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
        
        
    }
    
}
