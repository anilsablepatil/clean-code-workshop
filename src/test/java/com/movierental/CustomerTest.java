package com.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void test_customer_with_regular_children_new_release_movie_rented_one_day_each() {
        String expected = "Rental Record for Anil Sable\n" +
                "\tURI\t2.0\n" +
                "\tBoss Baby\t1.5\n" +
                "\tArtical 370\t3.0\n" +
                "Amount owed is 6.5\n" +
                "You earned 3 frequent renter points";
        Movie m1 = new Movie("URI", Movie.REGULAR);
        Movie m2 = new Movie("Boss Baby", Movie.CHILDRENS);
        Movie m3 = new Movie("Artical 370", Movie.NEW_RELEASE);

        Rental r1 = new Rental(m1,1);
        Rental r2 = new Rental(m2,1);
        Rental r3 = new Rental(m3, 1);

        Customer c1 = new Customer("Anil Sable");
        c1.addRental(r1);
        c1.addRental(r2);
        c1.addRental(r3);

        String str = c1.statement();
        Assert.assertEquals(str, expected);
    }

    @Test
    public void test_customer_with_regular_children_new_release_movie_rented_two_day_each() {
        String expected = "Rental Record for Anil Sable\n" +
                "\tURI\t2.0\n" +
                "\tBoss Baby\t1.5\n" +
                "\tArtical 370\t6.0\n" +
                "Amount owed is 9.5\n" +
                "You earned 4 frequent renter points";
        Movie m1 = new Movie("URI", Movie.REGULAR);
        Movie m2 = new Movie("Boss Baby", Movie.CHILDRENS);
        Movie m3 = new Movie("Artical 370", Movie.NEW_RELEASE);

        Rental r1 = new Rental(m1,2);
        Rental r2 = new Rental(m2,2);
        Rental r3 = new Rental(m3, 2);

        Customer c1 = new Customer("Anil Sable");
        c1.addRental(r1);
        c1.addRental(r2);
        c1.addRental(r3);

        String str = c1.statement();
        System.out.println(str);
        Assert.assertEquals(str, expected);
    }

    @Test
    public void test_customer_with_regular_children_new_release_movie_rented_five_day_each() {
        String expected = "Rental Record for Anil Sable\n" +
                "\tURI\t6.5\n" +
                "\tBoss Baby\t4.5\n" +
                "\tArtical 370\t15.0\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points";
        Movie m1 = new Movie("URI", Movie.REGULAR);
        Movie m2 = new Movie("Boss Baby", Movie.CHILDRENS);
        Movie m3 = new Movie("Artical 370", Movie.NEW_RELEASE);

        Rental r1 = new Rental(m1,5);
        Rental r2 = new Rental(m2,5);
        Rental r3 = new Rental(m3, 5);

        Customer c1 = new Customer("Anil Sable");
        c1.addRental(r1);
        c1.addRental(r2);
        c1.addRental(r3);

        String str = c1.statement();
        System.out.println(str);
        Assert.assertEquals(str, expected);
    }

    @Test
    public void test_customer_with_regular_children_new_release_movie_rented_one_day_each_html() {
        String expected = "<h1>Rental Record for <b>Anil Sable</b></h1> <br/>URI\n" +
                "2.0<br/>Boss Baby\n" +
                "1.5<br/>Artical 370\n" +
                "3.0<br/>Amount owed is <b>6.5</b><br/>You earned <b>3</b> frequent renter points <br/>";
        Movie m1 = new Movie("URI", Movie.REGULAR);
        Movie m2 = new Movie("Boss Baby", Movie.CHILDRENS);
        Movie m3 = new Movie("Artical 370", Movie.NEW_RELEASE);

        Rental r1 = new Rental(m1,1);
        Rental r2 = new Rental(m2,1);
        Rental r3 = new Rental(m3, 1);

        Customer c1 = new Customer("Anil Sable");
        c1.addRental(r1);
        c1.addRental(r2);
        c1.addRental(r3);

        String str = c1.htmlStatement();
        Assert.assertEquals(str, expected);
    }

    @Test
    public void singleLoopVsMultiple() {
        for (int j = 0; j < 100; j++) {

            //single loop
            int x = 0, y = 0, z = 0;
            long l = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                x++;
                y++;
                z++;
            }
            l = System.currentTimeMillis() - l;


            //multiple loops doing the same thing
            int a = 0, b = 0, c = 0;
            long m = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                a++;
            }
            for (int i = 0; i < 100000000; i++) {
                b++;
            }
            for (int i = 0; i < 100000000; i++) {
                c++;
            }
            m = System.currentTimeMillis() - m;
            System.out.println(String.format("%d,%d", l, m));

        }
    }
}