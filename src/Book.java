public class Book extends LibraryItem {
    private String isbn;


    public Book(String title, String isbn) {

        super(title);
        if (isbn == null || isbn.trim().isEmpty()) {
            throw  new IllegalArgumentException("ISBN cannot be null.");
        }
        this.isbn = isbn;
    }

    public String getISBN() {
        return isbn; //returns constructor value
    }

    public void setISBN(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null.");
        }
        this.isbn = isbn;
    }


    @Override
    public double getDailyLateFee() {
        return 0.25;
    }

    @Override
    public int getBaseLoanPeriod() {
        return 21;
    }

    @Override
    public double getMaximumFine() {
        return 20; //Max fine for an item
    }

    @Override
    public String toString() {
        return getTitle() + " (Book, ISBN: " + getISBN() + ")";
    }
}