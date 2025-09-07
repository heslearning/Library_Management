import java.util.*;

public class LibrarySystem {

    // The date manager is used in this assignment to provide an easier method for you to work with time logic.
    // It keeps track of the current day, and allows you to progress the current day with dateManager.advanceDays(numberOfDays).
    // This makes it easy for you to count overdue days, and makes it easier for you to test the system.
    //
    // In a real-world application, this would be replaced with a more powerful implementation of date/time logic.
    private DateManager dateManager = new DateManager();

    // Already implemented - returns access to the date manager handling the current simulated date for the library system.
    public DateManager getDateManager() {
        return dateManager;
    }

    //List to save users
    private List<LibraryUser>users;

    //List to save Library Items
    private List<LibraryItem>items;


    // LibrarySystem Constructor.
    public LibrarySystem() {
        users = new ArrayList<>(); //Initializing the list for users
        items = new ArrayList<>(); //Initializing the list for items

    }

    // This method should add the specified item to the library system (or throw an exception if the item is not valid or already added).
    public void addItem(LibraryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null item");
        }
        if (items.contains(item)) {
            throw new IllegalArgumentException("Item is already added");
        }
        items.add(item);

    }

    // This method should add a user to the library system (or throw an exception if the user is not valid or already added).
    public void addUser(LibraryUser user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot add a null user");
        }
        users.add(user);
    }

    // This method should loan a specific library item to a specific user. If the loan is not valid, it should throw
    // an appropriate exception (e.g., it should throw LoanLimitExceededException if the user is already at their borrow limit).
    public void loanItem(LibraryItem item, LibraryUser user) {
        if (item == null) {throw new IllegalArgumentException("Item cannot be null");}
        if (!items.contains(item)){
            throw new IllegalArgumentException("Item is not added to the database");
        }
        if (!users.contains(user)) {throw new IllegalArgumentException(("The user is not added to the database"));}
        if (user == null) {throw new IllegalArgumentException("User cannot be null");}
        if (user.getLoans().size() >= user.getLoanLimit())
            throw new LoanLimitExceededException("Loan limit exceeded.");
        if (!item.isAvailableForLoan()) {
            throw new ItemNotLoanableException("This item can not be loaned");
        }

        Loan loan = new Loan(item, user, dateManager);
        loan.processLoan();

    }

    // Returns the item to the library. This should throw an appropriate exception if the returning item is not valid.
    // If the item is overdue, you do not need to write code to handle paying the fines. Assume that the fines were
    // paid by the user during the return process.
    public void returnItem(LibraryItem item) {
        Loan loan = item.getCurrentLoan();
        loan.processReturn();

    }

    // This method returns a list of all library users in the system.
    // This method should return an unmodifiable list to prevent modification.
    public List<LibraryUser> getUsers () {
        return Collections.unmodifiableList(users);
    }

    // This method should return a list of all library items in the system.
    // This method should return an unmodifiable list to prevent modification.
    public List<LibraryItem> getLibraryItems() {
        return Collections.unmodifiableList(items);
    }

    // This method should return a list of all library items which can currently be borrowed in the system.
    // The method should return an unmodifiable list to prevent modification.
    public List<LibraryItem> getBorrowableItems () {
        List<LibraryItem>borrowableItems = new ArrayList<>();
        for (LibraryItem item: items) {
            if (!item.isOnLoan() && item.isAvailableForLoan()){
                borrowableItems.add(item);
            }
        }
        return borrowableItems;
    }


}