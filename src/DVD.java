public class DVD extends LibraryItem {
    private int runtimeMinutes;

    public DVD(String title, int runtimeMinutes) {
        super(title);
        this.runtimeMinutes = runtimeMinutes;
    }

    public int getRuntimeLength() {
        return runtimeMinutes;
    }

    public void setRuntimeLength(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    @Override
    public boolean isAvailableForLoan(){
        return true;
    }

    @Override
    public double getDailyLateFee() {
        return 1;
    }

    @Override
    public int getBaseLoanPeriod() {
        return 7;
    }

    @Override
    public double getMaximumFine() {
        return 30;
    }

    @Override
    public String toString() {
        return getTitle() + " (DVD, Runtime Length: " + getRuntimeLength()  + " Minutes)";
    }
}