import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contacts;
    private ArrayList<Group> groups;

    public AddressBook() {
        contacts = new ArrayList<>();
        groups = new ArrayList<>();
    }

    public boolean createContact(Contact contact){
        return contacts.add(contact);
    }

    public boolean removeContact(Contact contact){
        return contacts.remove(contact);
    }

    //getContacts method 
    public ArrayList<Contact> getContacts(){
        return new ArrayList<Contact>(contacts); //deep copy
    }

    public ArrayList<Group> getGroups(){
        return new ArrayList<Group>(groups); //deep copy
    }

// ========
// ======== SEARCH FUNCTIONS ========
    public Contact searchName(String name) { //searching by Name
            for (Contact c : contacts) {
                if (c.getName().equalsIgnoreCase(name)) {
                    return c;
                }
            }
            return null;
    }

    public Contact searchPhone(String phoneNumber) { // searching by Phone #
            for (Contact c : contacts) {
                if (c.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                    return c;
                }
            }
            return null;
    }

    public Contact searchEmail(String email) { // searching by Email
            for (Contact c : contacts) {
                if (c.getEmail().equalsIgnoreCase(email)) {
                    return c;
                }
            }
            return null;
    }



// ======== FILTER FUNCTIONS ========
public ArrayList<Contact> filterByType(String type) { //filtering by Type
        ArrayList<Contact> results = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getClass().getSimpleName().equalsIgnoreCase(type)) {
                results.add(c);
            }
        }
        return results;
    }

public ArrayList<Contact> filterByCity(String city) { //filtering by City
        ArrayList<Contact> results = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getCity().equalsIgnoreCase(city)) {
                results.add(c);
            }
        }
        return results;
    }

public ArrayList<Contact> filterByTags(ArrayList<String> tags) { // filtering by Tags
        ArrayList<Contact> results = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getTags().containsAll(tags)) {
                results.add(c);
            }
        }
        return results;
    }


    
    // ----- GROUPS METHODS -----

    //Returns false if groupname is empty/null or a group with the groupName you sent already exists
    public boolean createGroup(String groupName){
        if (groupName == null || groupName.isEmpty()) return false; //groupName is empty/null

        // Search groups in AddressBook if groupName already exists
        for (Group g : groups){
            if (g.getGroupName().equalsIgnoreCase(groupName)){
                return false; //group already exists
            }
        }

        groups.add(new Group(groupName));
        return true; // successfully created
    }

    //Returns false if either parameters is a null ref, a group with the groupName you sent doesnt exist,
    //or the contact reference you passed does not exist in the contacts ArrayList.
    //Must pass a contact as a reference to a contact from the contacts ArrayList to sucessfully add a contact
    public boolean addContactToGroup(Contact contact, String groupName){
        if (contact == null || groupName == null) return false; //contact or groupname is null
        if (!contacts.contains(contact)) return false; //contact isnt a reference that exists in ArrayList<> contacts

        for (Group g : groups) {
            if (g.getGroupName().equalsIgnoreCase(groupName)){
                g.addContact(contact);
                return true; //successfully added
            }
        }

        return false; //group not found
    }

    public Group searchForGroupByName(String groupName){
        for (Group g : groups){
            if(g.getGroupName().equalsIgnoreCase(groupName)){
                return g;
            }
        }
        return null;
    }

    public boolean removeGroup(Group group){
        return groups.remove(group);
    }


}


