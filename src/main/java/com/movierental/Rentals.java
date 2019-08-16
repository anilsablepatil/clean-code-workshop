package com.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : this) {
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public double calculateAmount() {
        double amount = 0;
        for(Rental each : this) {
            amount = amount + each.amount();
        }
        return amount;
    }
}
