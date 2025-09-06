import java.util.*;

public abstract class LibraryUser {

    private String name;
    private List<Loan> loans;


    // LibraryUser Constructor
    public LibraryUser (String name) {
        this.name = name;
        this.loans = new ArrayList<>();
    }

    // Setter for the user’s name. Should throw an appropriate exception if the name is not valid.
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the user’s name.
    public String getName() {
        return name;
    }

    // Assigns the specified loan to the user. This method should perform appropriate validation checks to ensure that
    // the loan is valid for the user, and throw appropriate exceptions as needed.
    public void assignLoan(Loan loan) {
        if (loan.getLibraryItem().getCurrentLoan() == null & loans.contains(loan.getLibraryItem()))
            throw new ItemUnavailableException("Item has already been loaned out");
        else if (this.isAtLoanLimit()) {
            throw new LoanLimitExceededException("The user is on at loan limit.");
        }
        loans.add(loan);
    }

    // Removes the specified loan from the user. Should throw an appropriate exception if the loan is not valid.
    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    // Returns true if the user’s current fine total equals or exceeds their suspension limit.
    public boolean isSuspended () {
        if (getTotalFines() > this.getFineSuspensionLimit()) {
            return true;
        }
        return false;
    }

    // Returns a list of loans currently active for the user.
    // This should be an unmodifiable list to prevent unexpected modification.
    public List<Loan> getLoans () {
        return Collections.unmodifiableList(loans);
    }

    // Returns the total amount of fines that the user has accrued.
    public double getTotalFines() {
        double total = 0.0;
        for (Loan loans : getLoans()) {
            if (loans.isOverdue()) {
                total = loans.getOverdueDays()*loans.getLibraryItem().getDailyLateFee() + loans.getLoanFine();
            }
        }
        return total;
    }

    // Returns true if the user is already at their loan limit and cannot borrow more items.
    public boolean isAtLoanLimit () {
        return false; // Dummy return value. Implement your own logic here then remove the comment.
    }

    // Returns a human-readable name for the user type. This has already been implemented for you.
    @Override
    public String toString () {
        return getName() + " (" + getUserRole() + ")";
    }

    public abstract int getLoanPeriodForItem(LibraryItem item);

    // Returns the loan limit for the user.
    // Refer to the assignment specifications to determine the appropriate value for the user type.
    public abstract int getLoanLimit();

    // Returns the fine rate modifier for the user.
    // Refer to the assignment specifications to determine the appropriate value for the user type.
    public abstract double getFineRateModifier();


    // Returns the total fines the user can accrue before they are suspended.
    // Refer to the assignment specifications to determine the appropriate value for the user type.
    public abstract double getFineSuspensionLimit();

    // Returns a human-readable name for the user type. This has already been implemented for you.
    public abstract String getUserRole();
}