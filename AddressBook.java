import java.util.ArrayList;
import java.util.Scanner;

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

public void displaySearch(Contact contact) {
        if (contact == null) {
            System.out.println("No contact found.");
        } else {
            System.out.println("Results: " + contact.toString());
        }
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

public void displayFiltered(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts matched.");
        } else {
            for (Contact c : contacts) {
                System.out.println(c.toString());
            }
        }
}

// ======== TAG MANAGER ========
public ArrayList<Contact> manageTags() { // adding and removing tags
        Scanner input = new Scanner(System.in);
        System.out.print("Enter contact name: ");
        String name = input.nextLine();

        Contact c = searchName(name);
        if (c == null) {
            System.out.println("Contact not found.");
            return contacts;
        }

        System.out.println("1. Add Tag\n");
        System.out.println("2. Remove Tag\n");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.print("Enter tag to add: ");
            String tag = input.nextLine();
            c.addTag(tag);
            System.out.println("Added tag successfully.");
        } else if (choice == 2) {
            System.out.print("Enter tag to remove: ");
            String tag = input.nextLine();
            c.removeTag(tag);
            System.out.println("Removed tag successfully");
        } else {
            System.out.println("Invalid input.");
        }

        return contacts;
    }
    // ========

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int choice = 0;

        while (choice != 9) {
            System.out.println("====== Address Book ======");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Contact");
            System.out.println("5. List All Contacts");
            System.out.println("6. Filter Contacts");
            System.out.println("7. Manage Groups");
            System.out.println("8. Reports");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Add Contact selected.");
                    break;

                case 2:
                    System.out.println("Edit Contact selected.");
                    break;

                case 3:
                    System.out.println("Delete Contact selected.");
                    break;

                case 4:
                    System.out.println("Search Contact selected.");
                    break;

                case 5:
                    addressBook.displayAllContacts();
                    break;

                case 6:
                    System.out.println("Filter Contacts selected.");
                    break;

                case 7:
                    System.out.println("Manage Groups selected.");
                    break;

                case 8:
                    System.out.println("Reports selected.");
                    break;

                case 9:
                    System.out.println("Exiting Address Book...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println();
        }

        input.close();
    }

   public void displayAllContacts() 
   {
    if (contacts.isEmpty()) 
    {
        System.out.println("No contacts found.\n");
        return;
    }

    for (Contact c : contacts) 
    {
        System.out.println(c.toString());
        System.out.println("----------------------");
    }
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

}





