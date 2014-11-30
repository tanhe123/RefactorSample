package net.xiayule;

/**
 * Rental 表示某个顾客租了一部影片
 * Created by tan on 14-11-30.
 */
public class Rental {
    /**
     * 租赁的影片
     */
    private Movie movie;

    /**
     * 租赁的天数
     */
    private int daysRented;

    /**
     * 租赁类的构造函数
     * @param movie 要租赁的影片类
     * @param daysRented 要租借的天数
     */
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getCharge() {
        double result = 0;
        // determine amounts for each line
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:// 对于普通影片, 两天内2元，超过2天，超出的每天收1.5元
                result += 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() -2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:// 对于新影片，每天3元收费
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:// 对于儿童片，3天内1.5元，超过3天，超出的每天收1.5圆
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }

    // set and get methods

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}
