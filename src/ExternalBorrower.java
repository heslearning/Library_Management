public class ExternalBorrower extends LibraryUser {

    public ExternalBorrower(String name) {
        super(name);
        // Implement your own additional logic here then remove the comment.
    }

    @Override
    public int getLoanPeriodForItem(LibraryItem item) {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public int getLoanLimit() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public double getFineRateModifier() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public double getFineSuspensionLimit() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public String getUserRole() {
        return "External Borrower";
    }
}