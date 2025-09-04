public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, int issueNumber) {
        super(title);
        this.issueNumber = issueNumber;

    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public boolean isAvailableForLoan(){
        return true;
    }
    @Override
    public double getDailyLateFee() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public int getBaseLoanPeriod() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public double getMaximumFine() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public String toString() {
        return getTitle() + " (Magazine, Issue " + getIssueNumber() + ")";
    }
}