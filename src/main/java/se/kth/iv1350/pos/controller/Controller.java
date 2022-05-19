package se.kth.iv1350.pos.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.dto.ItemDTO;
import se.kth.iv1350.pos.dto.Receipt;
import se.kth.iv1350.pos.integration.InventorySystemException;
import se.kth.iv1350.pos.model.ItemNotInSystemException;
import se.kth.iv1350.pos.model.Register;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.Util.ExceptionLogHandler;
import se.kth.iv1350.pos.model.RegisterRevenueObserver;

/**
 * The only controller for the POS system. 
 * All calls to model passes through this class.
 */
public class Controller {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private Sale sale;
    private Register cashRegister;
    private List<RegisterRevenueObserver> RegisterRevenueObserver = new ArrayList<>();
    
    /**
     * Creates a new instance.
     */
    public Controller (){
        accountingSystem = new AccountingSystem();
        inventorySystem = new InventorySystem();
        cashRegister = new Register();
    }
    
    /**
     * Starts a new sale.
     */
    public void startNewSale(){
        sale = new Sale();
    }
   
    /**
     * Gets information from inventory system and adds item to sale.
     * @param id Identifier of scanned item
     * @param quantity Amount of items to add
     * @return the item that was scanned
     * @throws InventorySystemException if there is a problem with the database
     * @throws ItemNotInSystemException if there is no item with matching item ID
     */
    public ItemDTO addItemToSale(int id, int quantity) throws ItemNotInSystemException, DataBaseFailedException{
        try {
        ItemDTO item = inventorySystem.returnItemToSale(id);
        sale.addItemToSale(item, quantity);
        return item;
        }
        catch (InventorySystemException InvSysExc){
            ExceptionLogHandler.logException(InvSysExc);
            throw new DataBaseFailedException();
        }
            
    }
    
    /**
     * Ends the current Sale. Updates external systems, 
     * updates amount in register and prints receipt
     * @param payment Amount that costumer gave to cashier
     */
    public void endSale(int payment) {
        accountingSystem.logCurrentSale(sale);
        inventorySystem.updateInventory(sale.getAllItems());
        cashRegister.updateAmountInRegister(sale.getTotalPriceIncludingVAT());
        cashRegister.printReceipt(getReceipt(sale), sale.getChangeToGiveToCostumer(payment), payment);
        startNewSale();
        
    }
    
    /**
     * Gets the total price of sale, including VAT
     * @return The total price of a Sale
     */
    public float getTotalPriceOfSale(){
        return sale.getTotalPriceIncludingVAT();
    }
    
    /**
     * Creates a new Receipt for the finished sale.
     * @param sale Sale information from a finished sale
     * @return Receipt The receipt that will be printed.
     */
    public Receipt getReceipt(Sale sale){
        return new Receipt(sale);
    }
    
    public void addRegisterRevenueObserver(RegisterRevenueObserver obs) {
        cashRegister.addRegisterRevenueObserver(obs);
        
    }
}
