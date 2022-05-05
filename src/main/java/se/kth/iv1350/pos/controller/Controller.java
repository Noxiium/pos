package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.Item;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.view.View;

/**
 * The only controller. All calls to model passes through this class.
 * 
 */
public class Controller {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private Sale sale;
    private CashRegister cashRegister;
    
    public Controller (){
        accountingSystem = new AccountingSystem();
        inventorySystem = new InventorySystem();
        cashRegister = new CashRegister();
    }
    
    /**
     * Starts a new sale.
     */
    public void startNewSale(){
        sale = new Sale();
    }
    
    public Sale getSale(){
        return sale;
    }
    /**
     * adds item to sale. Checks with inventorySystem to see if item exist.
     */
    public Item addItemToSale(int id) {
        Item item = inventorySystem.returnItemToSale(id);
        sale.addItemToSale(item);
        return item;
        
        
    }
    /**
     * adds item to sale with quantity. Checks with inventorySystem to see if item exist.
     */
    public Item addItemToSale(int id, int quantity) {
        Item item = inventorySystem.returnItemToSale(id);
        sale.addItemToSale(item, quantity);
        return item;
    }
    
    public float endSale(int payment) {
        accountingSystem.logCurrentSale(sale);
        inventorySystem.updateInventory(sale.getAllItems());
        float total = sale.getTotalPriceIncludingVAT();
        cashRegister.updateAmountInRegister(total);
        cashRegister.print(sale.getReceipt());
        return payment - total;
        
    }
    
    public float getTotalPriceOfSale(){
        return sale.getTotalPriceIncludingVAT();
    }
    
    
}
