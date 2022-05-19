package se.kth.iv1350.pos.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.iv1350.pos.model.RegisterRevenueObserver;

public class TotalRevenueFileOutput implements RegisterRevenueObserver{
    private static final String FILE_NAME = "revenue.txt";
    private PrintWriter printWriter;
    
    /**
     *  Creates a new instance.
     */
    public TotalRevenueFileOutput() {
        try {
            printWriter = new PrintWriter(new FileWriter(FILE_NAME, true), true);
        }
        catch(IOException exc) {
            exc.printStackTrace();
        }
    }
    
    /**
     * Called when the total revenue in the register is updated.
     * @param totalRevenue total revenue to be printed
     */
    @Override
    public void updateTotalRevenue(float totalRevenue){
        printWriter.println("Total revenue:" + totalRevenue);
    }
    
}
