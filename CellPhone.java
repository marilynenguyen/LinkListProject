
//-----------------------------
//Assignment #3
//Part 2
//Written by: Steven Lam(40226649) and Marilyne Nguyen(40228396)
//-----------------------------

/**
 * CellPhone class to create cellPhones objects 
 * 
 * It contains all the methods to create objects and that can be used on them
 * @author stevenlam(40226649) and marilynenguyen(40228396)
 *COMP249
 *Assignment #3
 *Due Date: December 5th, 2022
 */

import java.util.Scanner;

/**
 * CellPhone Class
 * @implements Cloneable interface 
 * @author stevenlam(40226649) and marilynenguyen(40228396)
 *
 */
public class CellPhone implements Cloneable {
	
	//Attributes 
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	/**
	 * Default constructor for the CellPhone class
	 * to set all the variables of a CellPhone object to default values
	 */
	public CellPhone() {
		this.serialNum = 1000;
		this.brand = "Apple";
		this.year = 2022;
		this.price = 500;
	}
	
	/**
	 * Parameterized constructor for the CellPhone class to set all the variables of a CellPhone
	 *  object to user's input
	 * @param serialNum a long value 
	 * @param brand a string value 
	 * @param year a integer value 
	 * @param price a double price 
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	/**
	 * 
	 * @param c a CellPhone value (copy constructor to copy an already existing CellPhone object) 
	 * @param serialNum a long value (must be different than the object we are copying)
	 */
	public CellPhone(CellPhone c, long serialNum) {
		this.serialNum = serialNum;
		this.brand = c.brand;
		this.year = c.year;
		this.price = c.price;
	}
	
	/**
	 * 
	 * @return a long serialNum type for a specific CellPhone object 
	 */
	public long getSerialNum() {
		return serialNum;
	}
	
	/**
	 * A method to set the input from the user to the serialNum variable
	 * @param  serialNum long
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	
	/**
	 * 
	 * @return String brand for a specific CellPhone object 
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * A method to set the input from the user to the brand variable
	 * @param brand String
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * 
	 * @return integer year for a specific CellPhone object 
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * A method to set the input from the user to the year variable
	 * @param year int 
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * 
	 * @return double price for a specific CellPhone object 
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * A method to set the input from the user to the price variable
	 * @param price double 
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * A method that returns the information of a specific CellPhone object. 
	 * This method overrides the original toString()
	 * method from the object superclass
	 */
	public String toString() {
		return "Serial number: " + serialNum +
				" - Brand: " + brand +
				" - Year: " + year +
				" - Price: " + price;
	}
	
	/**
	 * A method that verifies if two CellPhone objects are identical by comparing the value of their variables (except the serialNum).
	 * If they're the same  => return true, if not return false
	 * @param object 
	 * @return boolean
	 */
	public boolean equals(Object x) {
		if(x == null || this.getClass() != x.getClass()) {
			return false;
		}
		else {
			CellPhone c = (CellPhone)x;
			
			return(this.brand == c.brand &&
					this.year == c.year &&
					this.price == c.price);
		}
	}
	
	/**
	 * clone method (covarient return type)
	 * from the cloneable interface 
	 * @return CellPhone object 
	 */
	public CellPhone clone() {
		
		try {
			CellPhone c = (CellPhone)super.clone();
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter the Serial Number that you want to assign: ");
			long userSN = input.nextLong();
			c.serialNum = userSN;
			return c;
		}
		catch (CloneNotSupportedException e) {
			System.out.println("Cannot clone CellPhone! Clone not supported!");
			return null;
		}
	}

}



