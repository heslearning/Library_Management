public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, int issueNumber) {
        super(title);
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number cannot be less than zero");
        }
        this.issueNumber = issueNumber;

    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public double getDailyLateFee() {
        return 0.50;
    }

    @Override
    public int getBaseLoanPeriod() {
        return 14;
    }

    @Override
    public double getMaximumFine() {
        return 10;
    }

    @Override
    public String toString() {
        return getTitle() + " (Magazine, Issue " + getIssueNumber() + ")";
    }
}