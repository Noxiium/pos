package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import se.kth.iv1350.pos.model.Sale;

/**
 * Calls to the external accounting system.
 * In this program the system is hard coded.
 * The class represents a accounting system.
 * All it does is storing each finished sale in a ArrayList.
 * 
 */
public class AccountingSystem {
    private ArrayList<Sale> allSales;
    
    /**
     * Creates a instance with an empty ArrayList.
     */
    public AccountingSystem(){
        allSales = new ArrayList<>();
    }
    
    /**
     * Completed sale is logged in the accountingSystem
     * @param finished sale to be logged when payment has been done
     */
    public void logCurrentSale(Sale sale){
        allSales.add(sale);
    }
    
    public ArrayList<Sale> getAllSales(){
        return allSales;
    }
    
}
