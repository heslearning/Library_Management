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
        return 2; //ExternalBorrower can take only up to 2 loans at a time
    }

    @Override
    public double getFineRateModifier() {
        return 2.0;
    }

    @Override
    public double getFineSuspensionLimit() {
        return 5; //Maximum value of fine before suspension
    }

    @Override
    public String getUserRole() {
        return "External Borrower";
    }
}