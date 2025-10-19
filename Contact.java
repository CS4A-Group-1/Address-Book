import java.util.ArrayList;

public class Contact {

    //=============================
    // Data fields

    private String name;
    private String phoneNumber;
    private String email;
    private String city;
    private ArrayList<String> tags;

    //=============================
    // Constructors

    public Contact(String name, String phoneNumber , String email, String city) {
        this(name);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
    }
    public Contact(String name) {
        this.name = name;
        this.phoneNumber = "";
        this.email = "";
        this.city = "";
        this.tags = new ArrayList<>();
    }

    //=============================
    // Name

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    //=============================
    // Phone Number

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }
    
    //=============================
    // Email

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    //=============================
    // City
    
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    //=============================
    // Tags
    
    public String getTag(int index) {
        return this.tags.get(index);
    }
    public int getIndexOfTag(String tag) {
        return this.tags.indexOf(tag);
    }
    public void addTag(String tag) {
        this.tags.add(tag);
    }
    public void removeTag(int index) {
        this.tags.remove(index);
    }
    public void removeTag(String tag) {
        this.tags.remove(tag);
    }
    public ArrayList<String> getTags() {
        return this.tags;
    }
}