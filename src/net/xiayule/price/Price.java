package net.xiayule.price;

import net.xiayule.Movie;

/**
 * Created by tan on 14-11-30.
 */
abstract public class Price {
    public abstract int getPriceCode();

    /**
     * 收费函数
     * @return
     */
    abstract public double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
