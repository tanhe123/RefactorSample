package net.xiayule.price;

import net.xiayule.Movie;

/**
 * Created by tan on 14-11-30.
 */
public class ChildrensPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
