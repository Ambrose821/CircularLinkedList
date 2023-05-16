
import java.util.*;
import java.io.*;
public class BookList {
	private Node head;
	
	///////////////////////
	private class Node{
		private Book book;
		Node next;
		
		public Node(Book book) {
			super();
			this.book = book;
			this.next = next;
		}	
		
	}
	///////////////////////
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public BookList() {
		this.head = null;
		
	}
	
	public int getListSize() {
		int counter = 0;
		Node current = head;
		do {
			if (head == null) {
				counter = 0;
				break;
			}
			else {
			current = current.next;
			counter++;
			}
		}while(current != this.head);
		return counter;
	}
	
	public void addToStart(Book b) {
		Node first = new Node(b);
		if (this.head == null) {
			this.head = first;
			first.next = head;
		}
		else {
		
			Node current = this.head;
			while(current.next != this.head) {
				current = current.next;
			
			}
			current.next = first;
			first.next = this.head;
			this.head = first;
		
		}
	}
	
	public void storeRecordsByYear(int yr) {
		FileWriter fw =null;
		
		boolean hasYear = false;
		
		try {
		for(int i =0; i<this.getListSize()-1; i++) {
			if(this.nodePosition(i).book.getYear() == yr) {	
					hasYear = true;
					break;
			
			}
			else {
				System.out.println("No Books of this year exist.");
				
			}
			
		}
		if(hasYear) {
			File yearFile = new File(yr+".txt");
			fw = new FileWriter(yearFile);
			for(int j=0; j<this.getListSize()-1; j++) {
				if(this.nodePosition(j).book.getYear()==yr) {
					fw.write(this.nodePosition(j).book.toString()+"\n");
				}
			}
			fw.close();
		}
		
		
		}catch(Exception e) {
			e.getMessage();
		}
		
	}
	

	public void displayContent() {
		try {
		String arrow = "";
		for(int i =this.getListSize()-1; i>=0; i--) {
			
			if(this.nodePosition(i) == this.head) {
				arrow += "\n ==> head";
			}
			else{
				arrow = " ==>";
			}
			System.out.println(this.nodePosition(i).book.toString()+arrow);
			
		}
		}catch(NullPointerException e) {
			System.out.println("Bounds Incorrect");
		}
	}
	
	public Node nodePosition(int i) {
		int counter =0;
		Node current = this.head;
		Node returnNode = null;
		
		if(i>this.getListSize() || i<0) {
			System.out.println("Out of Bounds");
			
		}
		else {
			while(current.next != head) {
				current = current.next;
				counter++;
					if(i==0) {
						returnNode = head;
					}
					else if(i == counter) {
					returnNode =current;
					
				}
				
			}
			
		}
		return returnNode;
	}
	
}
