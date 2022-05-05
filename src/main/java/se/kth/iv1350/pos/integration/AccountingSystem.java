package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import se.kth.iv1350.pos.model.Sale;

public class AccountingSystem {
    private ArrayList<Sale> allSales;
    
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
    
}
