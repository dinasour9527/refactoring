package com.video;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 租客
 * @ClassName: Customer
 * @Description: TODO
 * @author dinasour
 * @date 2018年1月25日
 *
 */
public class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();
	
	public String getName() {
		return _name;
	}
	
	public void addRental(Rental rental) {
		_rentals.add(rental);
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "rental Record for " + getName() + "\n";
		
		while(rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental rental = rentals.nextElement();
			int priceCode = rental.getMovie().getPriceCode();
			int daysRented = rental.getDaysRented();
			//determine amount for each line
			switch(priceCode) {
				case Movie.REGULAR:
					thisAmount += 2;
					if(daysRented > 2) {
						thisAmount += (daysRented - 2) * 1.5;
					}
					break;
				case Movie.NEW_RELEASE:
					thisAmount += daysRented * 3;
					break;
				case Movie.CHILDRENS:
					thisAmount += 1.5;
					if(daysRented > 3) {
						thisAmount += (daysRented - 3) * 1.5;
					}
					break;
			}
			
			//add frequent renter points
			frequentRenterPoints++;
			//add bonus for a two day new release rental
			if(priceCode == Movie.NEW_RELEASE && daysRented > 1) {
				frequentRenterPoints++;
			}
			
			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t"
					+ thisAmount + "\n";
			totalAmount += thisAmount;
		}
		
		//add footer lines
		result += "Amount owed is " + totalAmount + "\n"
				+ "You earned " + frequentRenterPoints + "frequent renter points";
		return result;
	}
}
