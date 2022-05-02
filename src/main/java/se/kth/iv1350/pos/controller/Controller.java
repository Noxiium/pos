package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;

/**
 * The only controller. All calls to model passes through this class.
 * 
 */
public class Controller {
    private Sale sale;
    
    /**
     * Starts a new sale.
     */
    public void startNewSale(){
        sale = new Sale();
    }
}
