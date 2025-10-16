import java.util.ArrayList;

public class Group {
    private String label;
    private ArrayList<Contact> members;

    public Group(String groupName) {
        this.label = groupName;
        this.members = new ArrayList<>();
    }

    //Add contact to the group, if not already added
    public void addContact(Contact contact) {
        if (contact != null && !members.contains(contact)) {
            members.add(contact);
        }
    }

    //Remove a contact from the group
    public void removeContact(Contact contact) {
        members.remove(contact);
    }

    //Return list of all contacts in this group
    public ArrayList<Contact> listContacts() {
        return new ArrayList<>(members); 
    }

    //Return the name of the group
    public String getGroupName() {
        return label;
    }
}
