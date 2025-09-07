public class Loan {
    private LibraryItem libraryItem;
    private LibraryUser user;
    private DateManager dateManager;
    private int loanday;
    private int returnDay;
    private double loanFine;


    // Loan constructor.
    public Loan(LibraryItem libraryItem, LibraryUser user, DateManager dateManager) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        if (libraryItem == null) throw new IllegalArgumentException("Library item cannot be null");
        if (dateManager == null) throw new IllegalArgumentException("Date manager cannot be null");
        this.user = user;
        this.libraryItem = libraryItem;
        this.dateManager = dateManager;
        this.loanday = dateManager.getCurrentDay();
        this.loanFine = 0.0;
        this.returnDay =loanday + user.getLoanPeriodForItem(libraryItem);
    }

    // This processes the loan, recording the loan against the item and against the user. This should throw appropriate
    // exceptions if the loan cannot be processed (e.g., if a user is already at their loan limit). Note: You do not
    // need to throw the errors from this method specifically, as long as the errors are thrown when the method is called.
    public void processLoan() {
        if (user.isAtLoanLimit()) {
            throw new BorrowLimitExceededException("User exceeded its loan limit.");
        }
        if (libraryItem instanceof ReferenceOnlyBook) {
            throw new ItemNotLoanableException("This item is not for loan.");
        }
        if (libraryItem.isOnLoan()) {
            throw new ItemUnavailableException("This item is already on loan");
        }
        user.assignLoan(this);
        libraryItem.assignLoan(this);
    }

    // This handles the logic for returning the item. This will remove the record of the loan from both the user
    // and the item.
    public void processReturn () {
        if (isOverdue()) {
            this.loanFine = this.getLibraryItem().getMaximumFine()*this.user.getFineRateModifier();
        }
        user.removeLoan(this);
        libraryItem.removeLoan();
    }

    // Should return true if the item is currently overdue. An item is not overdue until the current day
    // exceeds the return day.
    public boolean isOverdue() {
        if (dateManager.getCurrentDay() > returnDay) {
            this.loanFine = this.getLibraryItem().getMaximumFine()*this.user.getFineRateModifier();
            return true;
        }
        return false;
    }

    // Should return the current value of the fine. If the item currently hasn’t accrued a fine because it is not
    // yet overdue, this should return 0.
    public double getLoanFine () {
        return this.loanFine + this.getOverdueDays()*this.libraryItem.getDailyLateFee();
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