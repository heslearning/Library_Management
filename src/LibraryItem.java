import java.util.LinkedList;
import java.util.Queue;

public abstract class LibraryItem {
    private String title;
    private Loan loan;

    // LibraryItem Constructor.
    public LibraryItem(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        this.title = title;
        loan = null;
    }

    //  Getter method for the item’s title.
    public String getTitle() {
        return title;
    }


    // Setter method for the item’s title. Should throw an appropriate exception if the title is not valid.
    public void setTitle(String title) {
        if (title == null && title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    // Returns the current loan information for the item, or null if not currently loaned.
    public Loan getCurrentLoan() {
        return loan;
    }

    // Assigns the specified loan to the item. This method should perform appropriate validation checks to ensure
    // that the loan is valid for the item, and throw appropriate exceptions as needed.
    public void assignLoan(Loan loan) {
        if (loan.getLibraryItem() != this) {
            throw new IllegalArgumentException("Not the right item");
        }
        if (this.loan != null) {
            throw new ItemUnavailableException("This item is already on loan.");
        }
        this.loan = loan;
    }

    // Removes the specified loan from the user. Should throw an appropriate exception if the loan is not valid.
    public void removeLoan() {
        if (loan == null) {
            throw new ItemUnavailableException("Item is not on loan");
        }
        loan = null;
    }

    // Returns true if currently loaned, otherwise false.
    public boolean isOnLoan() {
        return loan != null;
    }

    // Returns true if currently loaned, otherwise false.
    public boolean isAvailableForLoan() {
        return true;
    }

    // Returns the specific daily late fee for the library item (use the table provided).
    // Use the table provided in the assignment documentation to generate the values for the daily late fee.
    public abstract double getDailyLateFee ();

    // Returns the base loan period for the item (before any additional time due to user type is considered).
    // Use the table provided in the assignment documentation to generate the values for the base loan period.
    public abstract int getBaseLoanPeriod();

    // Returns the maximum possible fine for an overdue loan on this item.
    // Use the table provided in the assignment documentation to generate the values for the maximum fine.
    public abstract double getMaximumFine();
}