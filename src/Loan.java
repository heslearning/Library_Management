public class Loan {
    private LibraryItem libraryItem;
    private LibraryUser user;
    private DateManager dateManager;
    private int loanday;
    private int returnDay;


    // Loan constructor.
    public Loan(LibraryItem libraryItem, LibraryUser user, DateManager dateManager) {
        this.user = user;
        this.libraryItem = libraryItem;
        this.dateManager = dateManager;
        this.loanday = dateManager.getCurrentDay();
        this.returnDay =loanday + libraryItem.getBaseLoanPeriod() + user.getLoanPeriodForItem(libraryItem);
    }

    // This processes the loan, recording the loan against the item and against the user. This should throw appropriate
    // exceptions if the loan cannot be processed (e.g., if a user is already at their loan limit). Note: You do not
    // need to throw the errors from this method specifically, as long as the errors are thrown when the method is called.
    public void processLoan() {
        user.assignLoan(this);
        libraryItem.assignLoan(this);
    }

    // This handles the logic for returning the item. This will remove the record of the loan from both the user
    // and the item.
    public void processReturn () {
        user.removeLoan(this);
        libraryItem.removeLoan();
    }

    // Should return true if the item is currently overdue. An item is not overdue until the current day
    // exceeds the return day.
    public boolean isOverdue() {
        if (dateManager.getCurrentDay() > returnDay) {
            return true;
        }
        return false;
    }

    // Should return the current value of the fine. If the item currently hasn’t accrued a fine because it is not
    // yet overdue, this should return 0.
    public double getLoanFine () {
        if (!this.isOverdue()) {
            return 0.0;
        }
        return this.getLibraryItem().getMaximumFine()*this.user.getFineRateModifier();
    }

    // Should return the current number of days that the item is overdue (or zero if not yet overdue).
    public int getOverdueDays() {
        if (dateManager.getCurrentDay() > returnDay) {
            return dateManager.getCurrentDay() - returnDay;
        }
        return 0;
    }

    // Should return the day that the library item was borrowed.
    public int getCheckoutDay() {
        return loanday;
    }

    // Should return the day at which the item needs to be returned before fines begin.
    public int getReturnDay() {
        return returnDay;
    }

    // Getter method for the user associated with the loan.
    public LibraryUser getUser() {
        return user;
    }

    // Getter method for the library item associated with the loan.
    public LibraryItem getLibraryItem() {
        return libraryItem;  //returns a library item assigned to a loan
    }
}