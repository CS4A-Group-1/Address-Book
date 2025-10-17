public class Business extends Contact {

    //=============================
    // Data fields

    private String url;

    //=============================
    // Constructors

    public Business(String name, String phoneNumber, String email, String city, String url) {
        super(name, phoneNumber, email, city);
        this.url = url;
    }

    public Business(String name, String phoneNumber, String url) {
        this(name, phoneNumber, "", "", url);
    }

    public Business(String name, String phoneNumber) {
        this(name, phoneNumber, "", "", "");
    }

    //=============================
    // URL

    public String getUrl() {
        return this.url;
    }

    public void setString(String url) {
        this.url = url;
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
            + "URL: " + this.getUrl() + "\n";
    }
}
