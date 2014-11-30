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

    /**
     * 收费函数
     * @return
     */
    public double getCharge() {
        return getMovie().getCharge(daysRented);
    }

    /**
     * 获取常客积分
     */
    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    // set and get methods

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}
