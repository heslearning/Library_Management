public class Book extends LibraryItem {
    private String isbn;

    public Book(String title, String isbn) {

        super(title);
        this.isbn = isbn;
    }

    public String getISBN() {
        return isbn; // Dummy return value. Implement your own logic here then remove the comment.
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean isAvailableForLoan(){
        return true;
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
        return 20;
    }

    @Override
    public String toString() {
        return getTitle() + " (Book, ISBN: " + getISBN() + ")";
    }
}