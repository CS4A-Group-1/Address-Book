import java.util.ArrayList;
import java.util.Date;

public class AddressBook {
    private ArrayList<Contact> contacts;
    private ArrayList<Group> groups;

    public AddressBook() {
        contacts = new ArrayList<>();
        groups = new ArrayList<>();
    }

    // -------- createContact() METHODS -------- 
    //All methods check if name is empty/null, which is "pretty much" the only time createXContact() returns false.

    public boolean createPersonContact(String name, String phone, String email, String city, String relationship, String nickname, Date birthday) {
        if (name == null || name.isEmpty()) return false;

        Contact newPerson = new Person(name, phone, email, city, relationship, nickname, birthday);
        return contacts.add(newPerson);
    }

    public boolean createVendorContact(String name, String phone, String email, String city, String industry, String id) {
        if (name == null || name.isEmpty()) return false;

        Contact newVendor = new Vendor(name, phone, email, city, industry, id);
        return contacts.add(newVendor);
    }

    public boolean createBusinessContact(String name, String phone, String email, String city, String url) {
        if (name == null || name.isEmpty()) return false;

        Contact newBusiness = new Business(name, phone, email, city, url);
        return contacts.add(newBusiness);
    }

    public boolean createEmergencyContact(String name, String phone, String email, String city, int priorityLevel) {
        if (name == null || name.isEmpty()) return false;

        Contact newEmergency = new Emergency(name, phone, email, city, priorityLevel);
        return contacts.add(newEmergency);
    }

    //getContacts method 
    public ArrayList<Contact> getContacts(){
        return this.contacts;
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

// public void displaySearch(Contact contact) {
//         if (contact == null) {
//             System.out.println("No contact found.");
//         } else {
//             System.out.println("Results: " + contact.toString());
//         }
//     }

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

// public void displayFiltered(ArrayList<Contact> contacts) {
//         if (contacts.isEmpty()) {
//             System.out.println("No contacts matched.");
//         } else {
//             for (Contact c : contacts) {
//                 System.out.println(c.toString());
//             }
//         }
// }


   // public void displayAllContacts() 
   // {
   //  if (contacts.isEmpty()) 
   //  {
   //      System.out.println("No contacts found.\n");
   //      return;
   //  }

   //  for (Contact c : contacts) 
   //  {
   //      System.out.println(c.toString());
   //  }
   //  }
    
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

    public void groupSummary() {
        System.out.println();

        //if groups is empty, output that its empty
        if (groups.isEmpty()) {
            System.out.println("No groups available.");
           return;
        }

        //for every group, list all contact names
        //IE:
        /* 
        groupName:
         - contactName
        */
        for (Group g : groups) {
        System.out.println(g.getGroupName() + ":");
            for (Contact c : g.listContacts()) {
                System.out.println(" - " + c.getName());
            }
        System.out.println();
        }
    }

    public void listEmergencyContacts() {
        System.out.println("\n");

        System.out.println("---Emergency Contacts---");
        for (Contact c : contacts) {
            if (c instanceof Emergency) {
                System.out.println(c.toString());
            }
        }
    }

    public void listVendorContacts() {
        System.out.println("\n");

        System.out.println("---Vendor Contacts---");
        for (Contact c : contacts) {
            if (c instanceof Vendor) {
                System.out.println(c.toString());
            }
        }
    }

    public void listPersonContacts() {
         System.out.println("\n");

        System.out.println("---Person Contacts---");
        for (Contact c : contacts) {
            if (c instanceof Person) {
                System.out.println(c.toString());
            }
        }
    }

    public void listBusinessContacts() {
        System.out.println("\n");

        System.out.println("---Business Contacts---");
        for (Contact c : contacts) {
            if (c instanceof Business) {
                System.out.println(c.toString());
            }
        }
    }

    public void listMissing() {
        System.out.println("\nContacts Missing Phone number");
        System.out.print("\n");
        for (Contact c : contacts) {
            boolean missingPhone = c.getPhoneNumber() == null || c.getPhoneNumber().trim().isEmpty();

            if (missingPhone) {
                System.out.print("\n");
                System.out.println(c.toString());
            }
        }
        System.out.println("\nContacts Missing Email");
        System.out.print("\n");
        for (Contact c : contacts) {
            boolean missingEmail = c.getEmail() == null || c.getEmail().trim().isEmpty();

            if (missingEmail) {
                System.out.print("\n");
                System.out.println(c.toString());
            }
        }
    }

}


