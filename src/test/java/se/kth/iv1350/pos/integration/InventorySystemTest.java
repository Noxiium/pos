package se.kth.iv1350.pos.integration;

import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventorySystemTest {
    private Item item;
    private InventorySystem inventorySystem;
    
    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
    }
    
    @AfterEach
    public void tearDown() {
        inventorySystem = null;
    }

    @Test
    public void testAddItemToInventoryandSale() {
        int testID = 5;
        Item testItem = new Item(testID, "test", 10, 0.25f);
        inventorySystem.addItemToInventory(testItem, 10);
        Item testResult = inventorySystem.returnItemToSale(testID);
        assertEquals(testItem, testResult, "Searched item could not be found");
    }
    
}
