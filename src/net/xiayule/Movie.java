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
