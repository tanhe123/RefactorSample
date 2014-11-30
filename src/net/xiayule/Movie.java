package net.xiayule;

import net.xiayule.price.ChildrensPrice;
import net.xiayule.price.NewReleasePrice;
import net.xiayule.price.Price;
import net.xiayule.price.RegularPrice;

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
    private Price price;

    /**
     * 构造函数
     * @param title 影片名称
     * @param priceCode 影片类型
     */
    public Movie(String title, int priceCode) {
        this.title = title;
//        this.priceCode = priceCode;
        setPriceCode(priceCode);
    }

    /**
     * 收费函数
     * @return
     */
    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
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
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("priceCode 错误");
        }
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }
}
