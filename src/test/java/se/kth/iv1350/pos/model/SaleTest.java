package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.dto.ItemDTO;

public class SaleTest {
    private Sale saleTest;
    
    @BeforeEach
    public void setUp() {
        saleTest = new Sale();
    }
    
    @AfterEach
    public void tearDown() {
        Sale saleTest = null;
    }

   
    @Test
    public void testAddItemToSale_ItemNotInCurrentSale() {
        try{
        int quantity = 3;
        ItemDTO testItem = new ItemDTO(1, "test", 10, 0.25f);
        saleTest.addItemToSale(testItem, quantity);
        int compareExpAmount = quantity;
        int amount = saleTest.getAllItems().get(testItem);
        assertEquals(compareExpAmount, amount, "adding one item with a quantity as parameter to overloaded method does not work yet");
        }
        catch (Exception exc) {
            fail("Gave exception");
        }
    }
    
    @Test
    public void testAddItemToSale_ItemIsInCurrentSale() {
        try{
        int quantity = 3;
        ItemDTO testItem = new ItemDTO(1, "test", 10, 0.25f);
        saleTest.addItemToSale(testItem,1);
        saleTest.addItemToSale(testItem, (quantity));
        int compareExpAmount = quantity+1;
        int amount = saleTest.getAllItems().get(testItem);
        assertEquals(compareExpAmount, amount, "adding one item with a quantity, when one is already in hashmap does not work yet");
        }
        catch (Exception exc) {
            fail("Gave exception");
        }
    }

    @Test
    public void testCalculate_getTotalPriceIncludingVAT() {
        try{
        int quantity = 2;
        float testItemPrice = 10;
        float testItemVAT = 0.25f;
        
        ItemDTO testItem = new ItemDTO(1, "test", testItemPrice, testItemVAT);
        saleTest.addItemToSale(testItem, quantity);
        float total = saleTest.getTotalPriceIncludingVAT();
        float expected = (testItemPrice*(1+testItemVAT)*quantity);
        assertEquals(expected,total, "calculater failed");
        }
        catch (Exception exc) {
            fail("Gave exception");
        }
    }
    
    @Test
    public void testCalculate_getTotalPrice() {
        try{
        int quantity = 2;
        float testItemPrice = 10;
        float testItemVAT = 0.25f;
        
        ItemDTO testItem = new ItemDTO(1, "test", testItemPrice, testItemVAT);
        saleTest.addItemToSale(testItem, quantity);
        float total = saleTest.getTotalPrice();
        float expected = (testItemPrice*quantity);
        assertEquals(expected,total, "calculater failed");
        }
        catch (Exception exc) {
            fail("Gave exception");
        }
    }
    
    @Test
    public void testCalculate_getTotalVAT() {
        try{
        int quantity = 2;
        float testItemPrice = 10;
        float testItemVAT = 0.25f;
        
        ItemDTO testItem = new ItemDTO(1, "test", testItemPrice, testItemVAT);
        saleTest.addItemToSale(testItem, quantity);
        float total = saleTest.getTotalVAT();
        float expected = (testItemPrice*(testItemVAT)*quantity);
        assertEquals(expected,total, "calculater failed");
        }
        catch (Exception exc) {
            fail("Gave exception");
        }
    }
    
    @Test
    public void testCalculate_withManyItems() {
        int quantity1 = 1;
        float testItemPrice1 = 10;
        float testItemVAT1 = 0.25f;
        
        int quantity2 = 2;
        float testItemPrice2 = 8;
        float testItemVAT2 = 0.06f;
        
        try{
        ItemDTO testItem1 = new ItemDTO(1, "test", testItemPrice1, testItemVAT1);
        saleTest.addItemToSale(testItem1, quantity1);
        ItemDTO testItem2 = new ItemDTO(2, "test", testItemPrice2, testItemVAT2);
        saleTest.addItemToSale(testItem2, quantity2);
        float total = saleTest.getTotalPriceIncludingVAT();
        float expected = (testItemPrice1*(1+testItemVAT1)*quantity1)+(testItemPrice2*(1+testItemVAT2)*quantity2);
        assertEquals(expected,total, "calculater failed");
        }
        catch (Exception exc) {
            fail("Gave exception");
        }
        
    }
}
