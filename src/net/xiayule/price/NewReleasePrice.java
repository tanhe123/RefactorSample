package net.xiayule.price;

import net.xiayule.Movie;

/**
 * Created by tan on 14-11-30.
 */
public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1) // 新影片且租借1天以上增加2个积分
            return 2;
        else return 1;
    }
}
