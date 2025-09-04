public class Student extends LibraryUser {
    public Student(String name) {
        super(name);
        // Implement your own logic here (if needed) then remove the comment.
    }
    public int getLoanLimit() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    public int getLoanPeriodForItem(LibraryItem item) {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    public double getFineRateModifier() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public double getFineSuspensionLimit() {
        return 0; // Dummy return value. Implement your own logic here then remove the comment.
    }

    @Override
    public String getUserRole() {
        return "Student";
    }
}