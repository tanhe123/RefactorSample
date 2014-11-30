package net.xiayule.price;

import net.xiayule.Movie;

/**
 * Created by tan on 14-11-30.
 */
public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
