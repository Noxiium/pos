package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.integration.Item;

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
    public void testAddItemToSale_Item_ItemIsNotCurrentSale() {
        Item testItem = new Item(1, "test", 10, 0.25f);
        saleTest.addItemToSale(testItem);
        int compareExpAmount = 1;
        int amount = saleTest.getAllItems().get(testItem);
        assertEquals(compareExpAmount, amount, "item was not added to hashmap. If this failed next 3 also fails");
    }
    
    @Test
    public void testAddItemToSale_Item_ItemIsInCurrentSale() {
        Item testItem = new Item(1, "test", 10, 0.25f);
        saleTest.addItemToSale(testItem);
        saleTest.addItemToSale(testItem);
        int compareExpAmount = 2;
        int amount = saleTest.getAllItems().get(testItem);
        assertEquals(compareExpAmount, amount, "adding two of the same items at different times does not work yet");
    }
    


    @Test
    public void testAddItemToSale_Item_int_ItemNotInCurrentSale() {
        int quantity = 3;
        Item testItem = new Item(1, "test", 10, 0.25f);
        saleTest.addItemToSale(testItem, quantity);
        int compareExpAmount = quantity;
        int amount = saleTest.getAllItems().get(testItem);
        assertEquals(compareExpAmount, amount, "adding one item with a quantity as parameter to overloaded method does not work yet");
    }
    
    @Test
    public void testAddItemToSale_Item_int_ItemIsInCurrentSale() {
        int quantity = 3;
        Item testItem = new Item(1, "test", 10, 0.25f);
        saleTest.addItemToSale(testItem);
        saleTest.addItemToSale(testItem, (quantity));
        int compareExpAmount = quantity+1;
        int amount = saleTest.getAllItems().get(testItem);
        assertEquals(compareExpAmount, amount, "adding one item with a quantity, when one is already in hashmap does not work yet");
    }

    @Test
    public void testCalculate_getTotalPriceIncludingVAT() {
        int quantity = 2;
        float testItemPrice = 10;
        float testItemVAT = 0.25f;
        
        Item testItem = new Item(1, "test", testItemPrice, testItemVAT);
        saleTest.addItemToSale(testItem, quantity);
        float total = saleTest.getTotalPriceIncludingVAT();
        float expected = (testItemPrice*(1+testItemVAT)*quantity);
        assertEquals(expected,total, "calculater failed");
    }
    
    @Test
    public void testCalculate_getTotalPrice() {
        int quantity = 2;
        float testItemPrice = 10;
        float testItemVAT = 0.25f;
        
        Item testItem = new Item(1, "test", testItemPrice, testItemVAT);
        saleTest.addItemToSale(testItem, quantity);
        float total = saleTest.getTotalPrice();
        float expected = (testItemPrice*quantity);
        assertEquals(expected,total, "calculater failed");
    }
    
    @Test
    public void testCalculate_getTotalVAT() {
        int quantity = 2;
        float testItemPrice = 10;
        float testItemVAT = 0.25f;
        
        Item testItem = new Item(1, "test", testItemPrice, testItemVAT);
        saleTest.addItemToSale(testItem, quantity);
        float total = saleTest.getTotalVAT();
        float expected = (testItemPrice*(testItemVAT)*quantity);
        assertEquals(expected,total, "calculater failed");
    }
    
    @Test
    public void testCalculate_withManyItems() {
        int quantity1 = 1;
        float testItemPrice1 = 10;
        float testItemVAT1 = 0.25f;
        
        int quantity2 = 2;
        float testItemPrice2 = 8;
        float testItemVAT2 = 0.06f;
        
        Item testItem1 = new Item(1, "test", testItemPrice1, testItemVAT1);
        saleTest.addItemToSale(testItem1, quantity1);
        Item testItem2 = new Item(2, "test", testItemPrice2, testItemVAT2);
        saleTest.addItemToSale(testItem2, quantity2);
        float total = saleTest.getTotalPriceIncludingVAT();
        float expected = (testItemPrice1*(1+testItemVAT1)*quantity1)+(testItemPrice2*(1+testItemVAT2)*quantity2);
        assertEquals(expected,total, "calculater failed");
    }
    
    
    
}
