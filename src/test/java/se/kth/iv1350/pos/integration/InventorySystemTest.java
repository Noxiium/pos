package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.dto.ItemDTO;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventorySystemTest {
    private ItemDTO item;
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
        ItemDTO testItem = new ItemDTO(testID, "test", 10, 0.25f);
        inventorySystem.addItemToInventory(testItem, 10);
        ItemDTO testResult = inventorySystem.returnItemToSale(testID);
        assertEquals(testItem, testResult, "Searched item could not be found");
    }
    
    @Test
    public void testFillInventory(){
        int testID = 3;
        ItemDTO testResult = inventorySystem.returnItemToSale(testID);
        float result = testResult.getItemPrice();
        float exp = 10;
        assertEquals(exp, result, "FillInventory did not work when inventorySystem was created");
    }
    
    @Test
    public void testUpdateInventory(){
        HashMap<ItemDTO, Integer> soldItemsTest = new HashMap<>();
        ItemDTO testItem1 = new ItemDTO(1, "Choklad", 10, 0.25f);
        ItemDTO testItem2 = new ItemDTO(4, "Melon", 20, 0.25f);
        soldItemsTest.put(testItem1, 2);
        soldItemsTest.put(testItem2, 1);
        inventorySystem.updateInventory(soldItemsTest);
        int result1 = inventorySystem.getInventoryQuantity(1);
        int expR = 8;
        assertEquals(expR, result1, "Did not update inventory correctly ");
    }
}
