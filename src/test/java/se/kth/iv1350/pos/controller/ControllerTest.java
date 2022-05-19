package se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.dto.ItemDTO;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.dto.Receipt;
import se.kth.iv1350.pos.model.ItemNotInSystemException;
import se.kth.iv1350.pos.model.Register;
import se.kth.iv1350.pos.model.Sale;

public class ControllerTest {
    
    public ControllerTest() {
    }
    private Controller controller;
    private Register register;
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    
    @BeforeEach
    public void setUp() {
        controller = new Controller();
        register = new Register();
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
    }
    
    @AfterEach
    public void tearDown() {
        controller = null;
        register = null;
        inventorySystem = null;
        accountingSystem = null;
    }

    @Test
    public void testStartNewSale() {
        controller.startNewSale();
        float expected = 0;
        float result = controller.getTotalPriceOfSale();
        assertEquals(expected, result, "There was items in a new sale");
       
    }

    @Test
    public void testAddItemToSale() {
        controller.startNewSale();
        try{
        ItemDTO itemTest = controller.addItemToSale(1, 1);
        assertNotNull(itemTest, "Add item did not work");
        }
        catch (Exception ex){
            fail("Gave exception");
        }
    }
    
    @Test
    public void testAddItemToSaleWrongID(){
        controller.startNewSale();
        try {
            controller.addItemToSale(1000, 1);
        }
        catch (ItemNotInSystemException exc) {
            return;
        }
        catch (DataBaseFailedException exc) {
            fail("Gave wrong exception");
        }
        fail("Gave no exception");
    }
        
    @Test
    public void testDataBaseFailedException(){
            controller.startNewSale();
        try {
            controller.addItemToSale(100, 1);
        }
        catch (DataBaseFailedException exc) {
            return;
        }
        catch (ItemNotInSystemException exc) {
            fail("Gave wrong exception");
        }
        fail("Gave no exception"); 
    }

    @Test
    public void testEndSale() {
        controller.startNewSale();
        try {
            controller.endSale(50);
        }
        catch (NullPointerException e) {
            fail("Sale did not end correctly");
        }
    }

    @Test
    public void testGetTotalPriceOfSale() {
        try{
        controller.startNewSale();
        ItemDTO item1 = controller.addItemToSale(1, 1);
        ItemDTO item2 = controller.addItemToSale(2, 2);
        float expected = 1 * (item1.getItemPrice() + 
                        (item1.getItemPrice() * item1.getItemVAT()))
                        + 2 * (item2.getItemPrice() + 
                        (item2.getItemPrice() * item1.getItemVAT()));
        float result = controller.getTotalPriceOfSale();
        assertEquals(expected, result);
        } catch (Exception exc){
            fail("Gave exception");
        }
    }
}
