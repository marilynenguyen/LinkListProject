//-----------------------------
//Assignment #3
//Part 2
//Written by: Steven Lam(40226649) and Marilyne Nguyen(40228396)
//-----------------------------

/**
 * CellListUtilization class : contains the main method and the different special cases (testing our methods) 
 * @author stevenlam(40226649) and marilynenguyen(40228396)
 *COMP249
 *Assignment #3
 *Due Date: December 5th, 2022
 */


import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


/**
 * 
 * @author stevenlam and marilynenguyen
 *
 */
public class CellListUtilization {

	public static void main(String[] args) {

		//initializing 4 phonelists 
		CellList phoneList1 = new CellList(); 
		CellList phoneList2 = new CellList(); 
		CellList phoneList3 = new CellList();
		CellList phoneList4 = new CellList(); 
		
		//attributes 
		long num;
		String brand;
		double price;
		int year;
		
		//Creating different cellPhones
		CellPhone c1 = new CellPhone(); 
		CellPhone c2 = new CellPhone(c1, 200000); 
		CellPhone c3 = new CellPhone(300001, "Motorola", 2010, 345.79); 
		CellPhone c4 = new CellPhone(400000, "Apple", 2017, 500.49); 
		CellPhone c5 = new CellPhone(500005, "Samsungii", 2017, 600.79); 
		
		CellPhone c6 = new CellPhone(600006, "Samsung", 2022, 800.00); 
		CellPhone c7 = new CellPhone(707007, "Lenovo", 2019, 105.79); 
		CellPhone c8 = new CellPhone(c6, 880008); 
		CellPhone c9 = new CellPhone(909999, "Android", 2017, 360.99); 
		CellPhone c10 = new CellPhone(101010, "Applepe", 2022, 900.00); 
		
		//initializing sc to null
		Scanner sc = null;
		//Opening scanner to take user's input 
		Scanner input = new Scanner (System.in); 
		
		try {
			//opening file 
			sc= new Scanner(new FileInputStream("/Users/marilynenguyen/eclipse-workspace/Assignment3-Comp249(2)/bin/Cell_Info.txt"));
		}
		//Catch if there is an exception 
		catch(FileNotFoundException e) {
			System.out.println("Could not open file for reading, please check if the file exits.");
			System.exit(0);
		
		}
		
		
		System.out.println("Reading from the file : Cell_Info.txt");
		
		//Reading the file 
		while(sc.hasNextLine()) {
			
				num = Long.parseLong(sc.next());
				brand = sc.next();
				price = Double.parseDouble(sc.next());
				year = Integer.parseInt(sc.next());
					
				CellPhone newPhone = new CellPhone(num, brand, year, price);
				phoneList1.addToStart(newPhone);
					
		}
		
		System.out.println("List 1");
		phoneList1.displayContent();
		System.out.println("The numbers of phones in the list1 is " + phoneList1.size()); 
		
		System.out.println("---------------------------------------------------------------------------");
		//Creating phoneList2 
		phoneList2.addToStart(c1);
		phoneList2.addToStart(c3);
		//Testing our method insertAtIndex
		phoneList2.insertAtIndex(2, c2);
		phoneList2.addToStart(c4);
		phoneList2.addToStart(c5);
		
		System.out.println("\nOriginal List 2");
		phoneList2.displayContent();
		System.out.println("\nChanging the list2 ... ");
		System.out.println("Deleting cellPhone in list2 at index 4... ");
		//deleting at a certain index 
		phoneList2.deleteAtIndex(4); 
		//When we reach the end of the list
		System.out.println("Deleting cellPhone in list2 at index 9... ");
		//deleting at a certain index 
		phoneList2.deleteAtIndex(9);
		phoneList2.displayContent(); 
		
		System.out.println("\nReplacing cellPhone at index 3 and deleting the first cellphone...");
		//replacing 
		phoneList2.replaceAtIndex(3, c8);
		//deleting the start 
		phoneList2.deleteFromStart(); 
		phoneList2.displayContent(); 
		System.out.println("\nThe final numbers of phones in the list2 is " + phoneList2.size()); 
		
		phoneList4.addToStart(c1);
		phoneList4.addToStart(c8);
		phoneList4.addToStart(c4);
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("\nList 3");
		System.out.println("Deleting cellPhone in list2 at index 4... ");
		//deleting at a certain index
		phoneList3.deleteAtIndex(4); 
		System.out.println("Creating List 3...");
		
		//Creating phoneList3 
		System.out.println("Letting the user decide what serial number he wishes to attribute to a existing phone (clone) ");
		CellPhone c11 = c1.clone(); 
		
		phoneList3.addToStart(c6); 
		phoneList3.addToStart(c7); 
		phoneList3.addToStart(c8); 
		phoneList3.addToStart(c9); 
		phoneList3.addToStart(c10); 
		phoneList3.addToStart(c11); 
		phoneList3.insertAtIndex(5, c5); 
		
		
		System.out.println("\nDisplaying Original List 3 : ");
		phoneList3.displayContent(); 
		
		System.out.println("\nInserting new cellPhone in list3 at index 1 and deleting at index 10... ");
		phoneList3.insertAtIndex(1, c1); 
		//deleting at a certain index
		phoneList3.deleteAtIndex(10); 
		phoneList3.displayContent(); 
		System.out.println("\nThe final numbers of phones in the list2 is " + phoneList3.size()); 
	
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Comparing list2 and list3 :  ");
		if (phoneList2.equals(phoneList3)) {
			System.out.println("The lists are the same");
		}
		else {
			System.out.println("The lists are not the same");
		}
		
		
		System.out.println("Comparing list2 and list4 :  ");
		
		if (phoneList2.equals(phoneList4)) {
			System.out.println("The lists are the same");
		}
		else {
			System.out.println("The lists are not the same");
		}
	
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Finding phones by their serial numbers in the list 1 and enter -1 to quit: ");
		
		long findingSN = input.nextLong(); 
		
		while(findingSN != -1) {
			
			if (phoneList1.find(findingSN) != null) {
				System.out.println("Finding another phone by their serial numbers in the list 1 or enter -1 to quit:");
			} 
			
			else {
				System.out.println("Error : Cannot find that phone, please re-enter a valid serial number: ");
			} 
			
			findingSN = input.nextLong();
		}
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Testing if the list3 contains theses two serials numbers : ");
		System.out.println("For serial number : " + 123456);
		
		if(phoneList3.contains(123456)) {
			System.out.println("The phone with the serial number 123456 is in the list3");
		}
		else {
			System.out.println("The phone with the serial number 123456 is not in the list3");
			
		}
		
		System.out.println("For serial number : " + 909999);
		
		if(phoneList3.contains(909999)) {
			System.out.println("The phone with the serial number 909999 is in the list3");
			
		}
		else {
			System.out.println("The phone with the serial number 909999 is not in the list3");
			
		}
		
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("End of program");
		
		sc.close();
		input.close(); 
	}
	
	

}
