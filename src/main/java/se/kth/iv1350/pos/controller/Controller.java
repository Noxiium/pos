package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.integration.Item;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;

/**
 * The only controller. All calls to model passes through this class.
 * 
 */
public class Controller {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private Sale sale;
    
    /**
     * Starts a new sale.
     */
    public void startNewSale(){
        sale = new Sale();
    }
    /**
     * adds item to sale. Checks with inventorySystem to see if item exist.
     */
    public void addItemToSale(int id) {
        Item item = inventorySystem.returnItemToSale(id);
        sale.addItemToSale(item);
    }
    
    public void addItemToSale(int id, int quantity) {
        Item item = inventorySystem.returnItemToSale(id);
        sale.addItemToSale(item, quantity);
    }
}
