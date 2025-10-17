public class Emergency extends Contact {

    //=============================
    // Data fields

    private int priorityLevel;

    //=============================
    // Constructors

    public Emergency(String name, String phoneNumber, String email, String city, int priorityLevel) {
        super(name, phoneNumber, email, city);
        this.priorityLevel = priorityLevel;
    }

    public Emergency(String name, String phoneNumber, int priorityLevel) {
        this(name, phoneNumber, "", "", priorityLevel);
    }

    public Emergency(String name, String phoneNumber) {
        this(name, phoneNumber, "", "", 0);
    }

    //=============================
    // Priority Level

    public int getPriorityLevel() {
        return this.priorityLevel;
    } 

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    //=============================
    // Override

    @Override
    public String toString() {
        return ""
            + "Name: " + this.getName() + "\n"
            + "Phone Number: " + this.getPhoneNumber() + "\n"
            + "Email: " + this.getEmail() + "\n"
            + "City: " + this.getCity() + "\n"
            + "Priority Level: " + this.getPriorityLevel() + "\n";
    }
}
