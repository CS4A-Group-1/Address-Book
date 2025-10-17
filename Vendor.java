public class Vendor extends Contact {

    //=============================
    // Data fields

    private String industry;
    private String id;

    //=============================
    // Constructors

    public Vendor(String name, String phoneNumber, String email, String city, String industry, String id) {
        super(name, phoneNumber, email, city);
        this.industry = industry;
        this.id = id;
    } 

    public Vendor(String name, String phoneNumber, String industry, String id) {
        this(name, phoneNumber, "", "", industry, id);
    }

    public Vendor(String name, String phoneNumber) {
        this(name, phoneNumber, "", "", "", "");
    }

    //=============================
    // Industry

    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    //=============================
    // ID

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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
            + "Industry: " + this.getIndustry() + "\n"
            + "ID: " + this.getId() + "\n";
    }
}
