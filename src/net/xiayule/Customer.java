package net.xiayule;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer 表示顾客类
 * Created by tan on 14-11-30.
 */
public class Customer {
    /**
     * 顾客的名字
     */
    private String name;

    /**
     * 用于保存顾客的租赁信息
     */
    private List<Rental> rentals = new ArrayList<Rental>();

    /**
     * 构造函数
     * @param name 顾客的名字
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * 增加一个租借
     * @param rental 租借类
     */
    public void addRental(Rental rental) {
        rentals.add(rental);
    }


    /**
     * 生成详单的函数
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            double thisAmount = 0;

            thisAmount = amountFor(rental);

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    rental.getDaysRented() > 1) // 如果租借的是新影片且租借天数大于1,则再增加一积分
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rental) {
        double result = 0;
        // determine amounts for each line
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:// 对于普通影片, 两天内2元，超过2天，超出的每天收1.5元
                result += 2;
                if (rental.getDaysRented() > 2) {
                    result += (rental.getDaysRented() -2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:// 对于新影片，每天3元收费
                result += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:// 对于儿童片，3天内1.5元，超过3天，超出的每天收1.5圆
                result += 1.5;
                if (rental.getDaysRented() > 3)
                    result += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }


    // set and get methods

    public String getName() {
        return name;
    }
}
