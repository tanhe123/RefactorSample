package net.xiayule;

/**
 * 除了计算费用，还要为常客计算积分，积分会根据租片种类是否为新片而有不同
 * Created by tan on 14-11-30.
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    /**
     * 影片名称
     */
    private String title;

    /**
     * 影片类型, 分为普通片、儿童片和新片
     */
    private int priceCode;

    /**
     * 构造函数
     * @param title 影片名称
     * @param priceCode 影片类型
     */
    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

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

    /**
     * 获取常客积分
     */
    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1) // 新影片且租借1天以上增加2个积分
            return 2;
        else
            return 1;// 其他类型的影片增加一个积分
    }

    // set and get methods

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }
}
