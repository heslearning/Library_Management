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
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        return item.getBaseLoanPeriod() + 14; //Returns item's base loan + academic's additional loan period
    }

    @Override
    public double getFineRateModifier() {
        return 1.0;
    }

    @Override
    public double getFineSuspensionLimit() {
        return 20; //Maximum value of fine before suspension
    }

    @Override
    public String getUserRole() {
        return "Academic";
    }
}