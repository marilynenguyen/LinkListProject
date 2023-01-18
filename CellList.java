//-----------------------------
//Assignment #3
//Part 2
//Written by: Steven Lam(40226649) and Marilyne Nguyen(40228396)
//-----------------------------

/**
 * CellList Class in which it contains the CellNode class (create linkedList) 
 * @author stevenlam(40226649) and marilynenguyen(40228396)
 *COMP249
 *Assignment #3
 *Due Date: December 5th, 2022
 */

/**
 * CellList class in which we could create cellNode (nodes containing a cellphone object) 
 * @author stevenlam and marilynenguyen
 *
 */


public class CellList {

	//Start of Inner Class
	/**
	 * CellNode class => to create the nodes of our CellList (linkedlist) 
	 * @author stevenlam and marilynenguyen
	 *
	 */
	
	private class CellNode{
		
		//attributes of CellNode Class 
		private CellPhone c; //object that a CellNode will contains 
		private CellNode next; //the pointer that a CellNode points to 
		
		/**
		 * Default constructor for the CellNode class to set all the variables of an CellNode 
		 * object to default values
		 */
		public CellNode() {
			c = null;
			next = null;
		}
		
		/**
		 * Parameterized constructor for the CellNode class to set all the variables of 
		 * an CellNode object 
		 * @param c CellPhone 
		 * @param next CellNode
		 */
		public CellNode(CellPhone c, CellNode next) {
			this.c = c;
			this.next = next;
		}
		
		/**
		 * Copy constructor 
		 * @param cn CellNode
		 */
		public CellNode(CellNode cn) {
			this.c = cn.c.clone();
			next = cn.next;
		}
		
		/**
		 * Method to return a CellPhone object 
		 * @return CellPhone object 
		 */
		public CellPhone getCellPhone() {
			return this.c;
		}
		
		/**
		 * Method to set a CellPhone object 
		 * @param c CellPhone 
		 */
		public void setCellPhone(CellPhone c) {
			this.c = c;
		}
		
		/**
		 * Method to return a CellNode pointer
		 * @return CellNode object 
		 */
		public CellNode getCellNode() {
			return this.next;
		}
		
		/**
		 * Method to set a CellNode object
		 * @param cn CellNode
		 */
		public void setCellNode(CellNode cn) {
			this.next = cn;
		}
		
		/**
		 * clone method to clone a cellNode (deep copy) 
		 */
		public CellNode clone() {
			return new CellNode(this);
		}
	}
	//End of CellNode Class (inner class)
	
	//attributes of CellList Class 
	private CellNode head;
	private int size;
	
	/**
	 * Default constructor for the CellList class to set all the variables of an CellList  
	 * object to default values
	 */
	public CellList() {
		this.head = null;
		this.size = 0;
	}
	
	/**
	 * Copy constructor of a list  
	 * @param list CellList 
	 */
	public CellList(CellList list) {
		
		if(list.head == null) {
			head = null;
		}
		else {
			head = null;
			CellNode t1, t2, t3;
			t1 = list.head;
			t2 = t3 = null;
			 
			
			while(t1 != null) {
				if(head == null) {
					t2 = new CellNode(t1.c.clone(), null);
					head = t2;
				}
				else {
					t3 = new CellNode(t1.c.clone(), null);
					t2.next = t3;
					t2 = t3;
				}
				t1 = t1.next;
			}
			t2 = t3 = null;
		}
		size = list.size(); 
		
	}
	
	/**
	 * Method that returns the size of the linkedList 
	 * @return int 
	 */
	public int size() {
		if(head == null) {
			return 0;
		}
		int counter = 0;
		CellNode t = head;
		
		while(t != null) {
			counter++;
			t = t.next;
		}
		return counter;
	}
	
	/**
	 * Method to add CellNodes to a CellList at the start 
	 * @param c CellPhone 
	 */
	public void addToStart(CellPhone c) {
		this.head = new CellNode(c, head);
	}
	
	/**
	 *  Method to add CellNodes to a CellList at a certain index 
	 * @param index int 
	 * @param cp CellPhone 
	 */
	public void insertAtIndex(int index, CellPhone cp) {
		
		CellNode newPhone = new CellNode();
		newPhone.c = cp;
		newPhone.next = null;
		
		if(index < 1) {
			System.out.println("Error: Index should be greater or equal to 1.");
			return;
		}
		else if (index == 1) {
			newPhone.next = head;
			head = newPhone;
			return;
		}
		else if(index > this.size()) {
			System.out.println("Error: You cannot enter an element at this index.");
		}
		else {
			CellNode temp = head;			
			for(int i = 1 ; i < index -1 ; i++) {
				if(temp != null) {
					temp = temp.next;
				}
			}
			if(temp != null) {
				newPhone.next = temp.next;
				temp.next = newPhone;
			}
		}		
	}
	
	/**
	 *  Method to delete CellNode to a CellList at a certain index 
	 * @param index int 
	 */
	public void deleteAtIndex(int index) {
		
		if(head == null) {
			System.out.println("Error: You have an empty list.");
			return;
		}
		
		CellNode temp = head;
		
		if(index < 1) {
			System.out.println("Error: Index should be greater or equal to 1.");
			return;
		}
		else if(index == 1) {
			head = temp.next;
			return;
		}
		else if (index > this.size()) {
			System.out.println("Error: You cannot delete an element at this index.");
			return; 
		}
		
		else {
			for(int i = 1 ; i < index-1; i++) {
				if(temp != null) {
					temp = temp.next;
				}
			}
			if(temp == null || temp.next == null) {
				System.out.println("Error: You have reach the end of the list");
				return;
			}
		}
		System.out.println("Delete completed");
		CellNode next = temp.next.next;
		temp.next = next;
		
	}
	
	/**
	 *  Method to delete CellNode of a CellList at the start
	 */
	public void deleteFromStart() {
		
		CellNode temp = head; 
		
		if(head == null) {
			System.out.println("Error: You have an empty list.");
			return;
		}		
		else{
			head = temp.next; 
			System.out.println("Delete completed");
		}
		
	}
	
	/**
	 *  Method to replace a CellNode of a CellList at a certain index 
	 * @param index int 
	 * @param cp CellPhone 
	 */
	public void replaceAtIndex(int index, CellPhone cp) {
		
		CellNode newPhone = new CellNode();
		newPhone.c = cp;
		newPhone.next = null;
		
		if(head == null) {
			System.out.println("Error: You have an empty list.");
			return;
		}
		
		CellNode temp = head;
		
		if(index < 1) {
			System.out.println("Error: Index should be greater or equal to 1.");
			return;
		}
		else if(index == 1) {
			newPhone = head.next.next; 
			head = newPhone; 
			return;
		}
		else if (index > this.size()) {
			System.out.println("Error: You cannot enter an element at this index.");
		}
		
		else {
			for(int i = 1 ; i < index ; i++) {
				if(temp != null) {
					temp = temp.next;
				}
			}
			temp.c = cp; 
			System.out.println("Substitution completed");
			
		}
	}
	
	/**
	 *  Method to find CellNodes depending on the serial number 
	 * @param x long 
	 * @return CellNode address 
	 */
	public CellNode find(long x) {
		
		int counter = 0;
		
		if (head == null) {
			return null;
		}
		
		CellNode t = head;
		
		while(t != null) {
			counter++;
			
			if(t.c.getSerialNum() == x) {
				System.out.println("The number of iterations is " + counter);
				System.out.println("Found the phone at position " + counter);
				return t;
			}
			t = t.next;
		}
		return null;
	}
	
	
	/**
	 *  Method to check if a CellNodes with a certain serial number is in the to a CellList 
	 * @param x long 
	 * @return boolean value 
	 */
	public boolean contains(long x) {
		
		if(find(x) == null) {
			return false; 
		}
		else {
			return true;
		}
	}
		
	/**
	 * Method to check if two CellList is the same 
	 * @param cl CellList 
	 * @return boolean value 
	 */
	public boolean equals(CellList cl) {
			
			CellNode t1 = cl.head; 
			CellNode t2 = this.head; 
			
			if(this.size() != cl.size()) {
				return false; 
			}
			else if (t1 == null || t2 == null) {
				return false;
			}
			
			else {
				int size = cl.size();
				for(int i = 1 ; i < size ; i++) {
					if(t1.c.equals(t2.c)) {
						t1 = t1.next;
						t2 = t2.next;
					}
					else {
						return false;
					}
				}
				return true;	
			}
			
	}
	
	/**
	 * Method to display the content of a CellList 
	 */
	public void displayContent() {
			
			CellNode temp = head;
			
			if(temp == null) {
				System.out.println("Error: You have an empty list.");
				return;
			}
			else {
				System.out.println("Here is the content of the list: ");
				
				while(temp != null) {
					System.out.println(temp.c + " --> ");
					temp = temp.next;
				}
				System.out.println("NULL");
			}
		}	
	
}
//End of CellList Class (outer class)