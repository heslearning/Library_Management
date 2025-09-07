public class Student extends LibraryUser {
    public Student(String name) {
        super(name);
        // Implement your own logic here (if needed) then remove the comment.
    }
    public int getLoanLimit() {
        return 5; //Student can take up to 5 loans
    }

    public int getLoanPeriodForItem(LibraryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        return  item.getBaseLoanPeriod() + 7; //item's base loan period plus student's additional loan period
    }

    public double getFineRateModifier() {
        return 0.75; // Pays the 75% of the fine
    }

    @Override
    public double getFineSuspensionLimit() {
        return 10; //Maximum value of fine before suspension
    }

    @Override
    public String getUserRole() {
        return "Student";
    }
}