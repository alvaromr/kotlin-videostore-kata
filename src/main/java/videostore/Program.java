package videostore;

// This file is the original program.

import java.util.Enumeration;
import java.util.Vector;

public class Program {
    public static void main(String[] args) {
        Customer c = new
                Customer("Fred");
        c.addRental(    new Rental(new Movie("The game of thrones", Movie.NEW_RELEASE), 1));
        //my favourite
        c.addRental(new Rental(new Movie(("Cinderella"), Movie.CHILDRENS), 2));
            c.addRental(new Rental(new Movie("Mr. Robot", Movie.REGULAR), 1));
                c.addRental(new Rental(
                        new Movie("The Hobbit", Movie.REGULAR), 3) //8 days rented
                );

        System.out.println(c.statement());;
    }
}

class Customer
{
    public Customer (String name) {
        this.name = name;
    }

    public void addRental (Rental rental) {
        rentals.addElement (rental);
    }

    public String getName () {
        return name;
    }

    public String statement () {
        double 				totalAmount 			= 0;
        int					frequentRenterPoints 	= 0;
        Enumeration rentals 				= this.rentals.elements ();
        String 				result 					= "Rental Record for " + getName () + "\n";

        while (rentals.hasMoreElements ()) {
            double 		thisAmount = 0;
            Rental 		each = (Rental)rentals.nextElement ();

            // determines the amount for each line
            switch (each.getMovie ().getPriceCode ()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented () > 2)
                        thisAmount += (each.getDaysRented () - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented () * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented () > 3)
                        thisAmount += (each.getDaysRented () - 3) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            if (each.getMovie ().getPriceCode () == Movie.NEW_RELEASE
                    && each.getDaysRented () > 1)
                frequentRenterPoints++;

            result += "\t" + each.getMovie ().getTitle () + "\t"
                    + String.valueOf (thisAmount) + "\n";
            totalAmount += thisAmount;

        }

        result += "You owed " + String.valueOf (totalAmount) + "\n";
        result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";


        return result;
    }


    private String name;
    private Vector rentals = new Vector ();
}


class Movie
{
    public static final int CHILDRENS	= 2;
    public static final int REGULAR 	= 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie (String title, int priceCode) {
        this.title 		= title;
        this.priceCode 	= priceCode;
    }

    public int getPriceCode () {
        return priceCode;
    }

    public void setPriceCode (int code) {
        priceCode = code;
    }

    public String getTitle () {
        return title;
    }

}

class Rental
{
    public Rental (Movie movie, int daysRented) {
        this.movie 		= movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented () {
        return daysRented;
    }

    public Movie getMovie () {
        return movie;
    }

    private Movie movie;
    private int daysRented;
}