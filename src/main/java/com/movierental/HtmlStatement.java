package com.movierental;

public class HtmlStatement {
    public String display(String name, Rentals rentals) {
        String result = "<h1>Rental Record for <b>" + name + "</b></h1> <br/>";
        for (Rental each : rentals) {
            //show figures for this rental
            result += "" + each.getMovie().getTitle() + "\n" +
                    String.valueOf(each.amount()) + "<br/>";
        }

        //add footer lines result
        result += "Amount owed is <b>" + String.valueOf(rentals.calculateAmount()) + "</b><br/>";
        result += "You earned <b>" + String.valueOf(rentals.getFrequentRenterPoints())
                + "</b> frequent renter points <br/>";
        return result;
    }
}
