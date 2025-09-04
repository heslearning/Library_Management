public class Loan {
    private LibraryItem libraryItem;
    private LibraryUser user;
    private int loanDay;
    // Loan constructor.
    public Loan(LibraryItem libraryItem, LibraryUser user, int dateManager) {
        this.user = user;
        this.libraryItem = libraryItem;
        this.loanDay = dateManager;
    }

    // This processes the loan, recording the loan against the item and against the user. This should throw appropriate
    // exceptions if the loan cannot be processed (e.g., if a user is already at their loan limit). Note: You do not
    // need to throw the errors from this method specifically, as long as the errors are thrown when the method is called.
    public void processLoan() {
        // Implement your own logic here then remove the comment.
    }

    // This handles the logic for returning the item. This will remove the record of the loan from both the user
    // and the item.
    public void processReturn () {
        // Implement your own logic here then remove the comment.
    }

    // Should return true if the item is currently overdue. An item is not overdue until the current day
    // exceeds the return day.
    public boolean isOverdue() {
        return false; // Dummy return value. Implement your own logic here then remove the comment.
    }

    // Should return the current value of the fine. If the item currently hasn’t accrued a fine because it is not
    // yet overdue, this should return 0.
    public double getLoanFine () {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    // Should return the current number of days that the item is overdue (or zero if not yet overdue).
    public int getOverdueDays() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    // Should return the day that the library item was borrowed.
    public int getCheckoutDay() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    // Should return the day at which the item needs to be returned before fines begin.
    public int getReturnDay() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    // Getter method for the user associated with the loan.
    public LibraryUser getUser() {
        return null; // Dummy return value. Implement your own logic here then remove the comment.
    }

    // Getter method for the library item associated with the loan.
    public LibraryItem getLibraryItem() {
        return libraryItem;  //returns a library item assigned to a loan
    }
}