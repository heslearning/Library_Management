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
        return 14;
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