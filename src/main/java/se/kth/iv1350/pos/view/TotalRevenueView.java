package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.RegisterRevenueObserver;

public class TotalRevenueView implements RegisterRevenueObserver {
    
    /**
     * Observes register. Writes to console when amount in
     * register changes.
     */
    @Override
    public void updateTotalRevenue(float totalRevenue) {
        System.out.println("Total revenue:" + totalRevenue);
    }
    
}
