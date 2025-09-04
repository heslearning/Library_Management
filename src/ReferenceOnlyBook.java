public class ReferenceOnlyBook extends Book {
    public ReferenceOnlyBook(String title, String isbn) {
        super(title, isbn);
        // Implement your own logic here (if needed) then remove the comment.
    }

    @Override
    public void assignLoan(Loan loan) {
        // Implement your own logic here then remove the comment.
    }


    @Override
    public boolean isAvailableForLoan() {
        return false;
    }

    @Override
    public int getBaseLoanPeriod() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public String toString() {
        return getTitle() + " (Reference Book, ISBN: " + getISBN() + ")";
    }
}