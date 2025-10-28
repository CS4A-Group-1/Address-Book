import java.util.Calendar;
import java.util.Date;

public class Person extends Contact {

    //=============================
    // Data fields

    private String relationship;
    private String nickname;
    private Date birthday;

    //=============================
    // Constructors

    public Person(String name, String phoneNumber, String email, String city, String relationship, String nickname, Date birthday) {
        super(name, phoneNumber, email, city);
        this.relationship = relationship;
        this.nickname = nickname;
        this.birthday = birthday;
    }

    public Person(String name, String phoneNumber) {
        this(name, phoneNumber, "", "", "", "", new Date());
    }

    public Person(String name) {
        this(name, "", "", "", "", "", new Date());
    }

    //=============================
    // Relationship

    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    //=============================
    // Nickname

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    //=============================
    // Birthday

    public Date getBirthday() {
        return this.birthday;
    }

    public String getBirthdayString() {
        Calendar bdayCalendar = Calendar.getInstance();
        bdayCalendar.setTime(this.birthday);
        int day = bdayCalendar.get(Calendar.DAY_OF_MONTH);
        int month = bdayCalendar.get(Calendar.MONTH) + 1;
        int year = bdayCalendar.get(Calendar.YEAR);

        return String.format("%02d/%02d/%04d", month, day, year);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //=============================
    // Override

    @Override
    public String toString() {
        return ""
            + "Name: " + this.getName() + "\n"
            + "Phone: " + this.getPhoneNumber() + "\n"
            + "Email: " + this.getEmail() + "\n"
            + "City: " + this.getCity() + "\n"
            + "Tags: " + this.getTags() + "\n"
            + "Relationship: " + this.getRelationship() + "\n"
            + "Nickname: " + this.getNickname() + "\n"
            + "Birthday: " + this.getBirthdayString() + "\n";
    }
}
