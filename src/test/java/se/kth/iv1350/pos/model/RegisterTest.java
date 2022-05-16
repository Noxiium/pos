package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest {
    private Register register;
   
    public RegisterTest() {
    }
    
    @BeforeEach
    public void setUp() {
        register = new Register();
    }
    
    @AfterEach
    public void tearDown() {
        register = null;
    }

    @Test
    public void testUpdateAmountInRegister() {
        float total = 125;
        float expected = register.getAmountInRegister()+125;
        register.updateAmountInRegister(total);
        float result = register.getAmountInRegister();
        assertEquals(expected, result, "Amount in register was not updated correctly");
        
    } 
}
