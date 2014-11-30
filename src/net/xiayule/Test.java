package net.xiayule;

/**
 * Created by tan on 14-11-30.
 */
public class Test {
    public static void main(String[] args) {


        Customer customer = new Customer("tan");
        customer.addRental(new Rental(new Movie("小", 1), 3));



        System.out.println(customer.statement());
    }
}
