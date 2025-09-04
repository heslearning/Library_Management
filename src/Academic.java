    public class Academic extends LibraryUser {

    public Academic(String name) {
        super(name);
    }
    @Override
    public int getLoanLimit() {
        return 10; //An academic can take up to 10 loans at a time
    }

    @Override
    public int getLoanPeriodForItem(LibraryItem item) {
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
        return "Academic";
    }
}