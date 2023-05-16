
public class Book {

	
	private String title;
	private String author;
	private double price;
	private long isbn;
	private String genre;
	private int year;
	
	int index;
	
	public Book(String title, String author, double price, long isbn, String genre, int year) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.genre = genre;
		this.year = year;
	}
	
	public Book(int index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public long getIsbn() {
		return isbn;
	}


	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	
	
	@Override
	public String toString() {
		return title + ", " + author + ", " + price + ", " + isbn + ", "
				+ genre + ", " + year ;
	}


	public static void main (String [] args) {
				FileHandler fh = new FileHandler();
				fh.writeErrorBooks();
				
				
			BookList bl = fh.addBooksToList();
			
			bl.storeRecordsByYear(1905);
			
			
			bl.displayContent();
	}
	
	
	
}
