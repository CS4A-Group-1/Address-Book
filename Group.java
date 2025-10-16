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

    //Remove a contact from the group, return 1 or 0 if remove was successful or not
    // !Current problem! : 
    // Java remove() checks equality based off "reference equality", so to remove an object you must pass its exact REFERENCE.
    // could override equals() method in Object class to fix, but contact class is not finished so this is what we got :p (might not be relevant anyways..)
    public boolean removeContact(Contact contact) {
        return members.remove(contact);
    }

    //Return list of all contacts in this group
    public ArrayList<Contact> listContacts() {
        return new ArrayList<>(members); //RETURNS COPY
    }

    //Return the name of the group
    public String getGroupName() {
        return label;
    }
}
