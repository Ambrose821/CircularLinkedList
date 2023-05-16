import java.io.*;
import java.util.*;
public class FileHandler {

	
	public boolean isCorrectYear(Book b) {
		if (b.getYear() > 2023) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public  Book StringToBook(String bookString) {
		String [] attributes = bookString.split(",");
		
		String title = new String(attributes[0].trim());
		String author = new String(attributes[1].trim());
		Double price = Double.valueOf(attributes[2].trim());
		long isbn = Long.valueOf(attributes[3].trim());
		String genre = new String(attributes[4].trim());
		int year = Integer.valueOf(attributes[5].trim());
		
		Book book = new Book(title, author, price, isbn, genre, year);
		return book;
	}
	
	public ArrayList<Book> createArrayListofIncorrectBooks() {
		
		Scanner sc = null;
		int counter = 0;
		ArrayList<Book> incorrectBooks= new ArrayList<Book>();
		try {
			
			sc = new Scanner(new FileInputStream("Books.txt"));
			
			while(sc.hasNextLine()) {
				Book b = StringToBook(sc.nextLine());
				
				if (!isCorrectYear(b)) {
					incorrectBooks.add(b);
				}
			
			}
		
		sc.close();
			return incorrectBooks;	
			
		}
		
		catch(FileNotFoundException e) {
			e.getMessage();
			sc.close();
			return incorrectBooks;
			
		}
		catch(NoSuchElementException e) {
			System.out.println("EOF");
			return incorrectBooks;
		}
	
		catch(NullPointerException e) {
		System.out.println("null");
		return incorrectBooks;
		}
	
		
	}
public ArrayList<Book> createArrayListofCorrectBooks() {
		
		Scanner sc = null;
		int counter = 0;
		ArrayList<Book> CorrectBooks= new ArrayList<Book>();
		try {
			
			sc = new Scanner(new FileInputStream("Books.txt"));
			
			while(sc.hasNextLine()) {
				Book b = StringToBook(sc.nextLine());
				
				if (isCorrectYear(b)) {
					CorrectBooks.add(b);
				}
			
			}
		
		sc.close();
			return CorrectBooks;	
			
		}catch(Exception e) {
			e.getMessage();
			return CorrectBooks;
			}
	
		
	}
	
	public void writeErrorBooks() {
		ArrayList<Book> book = createArrayListofIncorrectBooks();
		FileWriter fw = null;
		File errorFile = new File("YearErr.txt");
		
		try {
			fw = new FileWriter(errorFile);
			for(int i =0; i<book.size(); i++) {
				fw.write(book.get(i).toString()+"\n");
		
			}
			fw.close();
			
		}
		catch(Exception e) {
			e.getMessage();
		}
		
	}
	
	public BookList addBooksToList() {
		ArrayList<Book> book = createArrayListofCorrectBooks();
		BookList bl = new BookList();
		
			
			for(int i =0; i<book.size(); i++) {
				bl.addToStart(book.get(i));
				
			}
			return bl;
			
		
		
	}
	
}
