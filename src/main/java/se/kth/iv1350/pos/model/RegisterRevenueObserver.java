package se.kth.iv1350.pos.model;

/**
 * An observer interface. Called when the total
 * amount in the register changes.
 * 
 */
public interface RegisterRevenueObserver {
    void updateTotalRevenue(float totalRevenue);
}
