package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.dto.ItemDTO;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.ItemNotInSystemException;
import se.kth.iv1350.pos.model.Sale;

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
    public void InventorySystemExceptionTest(){
        try{
            inventorySystem.returnItemToSale(100);
        }
        catch (InventorySystemException InvSysExc){
            return;
        }
        catch (ItemNotInSystemException ItNoInSysExc){
            fail("Wrong exception was thrown");
        }
        fail("No expected exception was thrown");
    }
    
    @Test
    public void returnItemToSaleWrongIdTest(){
        try{
            inventorySystem.returnItemToSale(1000);
        }
        catch (ItemNotInSystemException ItNoInSysExc) {
            return;
        }
        fail("No expected exception was thrown");
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
        int expected = 8;
        assertEquals(expected, result1, "Did not update inventory correctly ");
    }
}
