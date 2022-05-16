package se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.dto.ItemDTO;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.dto.Receipt;
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
        ItemDTO itemTest = controller.addItemToSale(1, 0);
        assertNotNull(itemTest, "Add item did not work");
    }

    @Test
    public void testEndSale() {
        controller.startNewSale();
        controller.addItemToSale(1, 1);
        try {
            controller.endSale(50);
        }
        catch (NullPointerException e) {
            fail("Sale did not end correctly");
        }
    }

    @Test
    public void testGetTotalPriceOfSale() {
        controller.startNewSale();
        ItemDTO item1 = controller.addItemToSale(1, 1);
        ItemDTO item2 = controller.addItemToSale(2, 2);
        float expected = 1 * (item1.getItemPrice() + 
                        (item1.getItemPrice() * item1.getItemVAT()))
                        + 2 * (item2.getItemPrice() + 
                        (item2.getItemPrice() * item1.getItemVAT()));
        float result = controller.getTotalPriceOfSale();
        assertEquals(expected, result);
    }
}
