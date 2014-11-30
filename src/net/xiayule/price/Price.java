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
    public double getCharge(int daysRented) {
        double result = 0;
        // determine amounts for each line
        switch (getPriceCode()) {
            case Movie.REGULAR:// 对于普通影片, 两天内2元，超过2天，超出的每天收1.5元
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented -2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:// 对于新影片，每天3元收费
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:// 对于儿童片，3天内1.5元，超过3天，超出的每天收1.5圆
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }
}
