import java.util.ArrayList;
import java.util.Date;
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

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    AddressBook addressBook = new AddressBook();
    int choice = 0;

    while (choice != 7) {
        //"wipe" the screen
        System.out.println("\n \n \n \n \n");

        // Main menu
        System.out.println("====== Address Book ======");
        System.out.println("1. Add Contact");
        System.out.println("2. Search Address Book for a Contact");
        System.out.println("3. List All Contacts");
        System.out.println("4. Filter and Display Contacts");
        System.out.println("5. Manage Groups");
        System.out.println("6. Reports");
        System.out.println("7. Exit");
        System.out.print("Enter choice: ");

        String line = input.nextLine().trim();
        if (line.isEmpty()) continue;
        try {
            choice = Integer.parseInt(line);
        } catch (Exception e) {
            choice = 0;
        }

        switch (choice) {

            case 1: {
                //"wipe" the screen
                System.out.println("\n \n \n \n \n");

                // Add contact by type
                System.out.println("Type:\n 1.) Person\n 2.) Business\n 3.) Vendor\n 4.) Emergency\n 5.) Back to Main Menu ");
                System.out.print("Enter type: ");
                int t;
                try {
                    t = Integer.parseInt(input.nextLine().trim());
                } catch (Exception e) {
                    t = -1;
                }

                //input check/back to main menu
                boolean isInvalidInput = t < 1 || t > 5;
                if (isInvalidInput){
                    //tell the user their input is invalid and tell them to try again with a pause.
                    System.out.println("\nInvalid input, try again.");
                    pause(input);
                    break;
                } 

                //go back to main menu
                if (t == 5){
                    break;
                } 

                // Common fields
                System.out.print("Name: ");
                String name = input.nextLine().trim();
                System.out.print("Phone: ");
                String phone = input.nextLine().trim();
                System.out.print("Email: ");
                String email = input.nextLine().trim();
                System.out.print("City: ");
                String city = input.nextLine().trim();

                boolean ok = false;

                if (t == 1) {
                    // Person extras
                    System.out.print("Relationship: ");
                    String rel = input.nextLine().trim();
                    System.out.print("Nickname: ");
                    String nick = input.nextLine().trim();

                    // Birthday in mm dd yyyy, also accepts mm/dd/yyyy or mm-dd-yyyy
                    System.out.print("Birthday mm dd yyyy: ");
                    String b = input.nextLine().trim().replace('-', ' ').replace('/', ' ');
                    String[] parts = b.split("\\s+");
                    if (parts.length == 3) {
                        try {
                            int m = Integer.parseInt(parts[0]);
                            int d = Integer.parseInt(parts[1]);
                            int y = Integer.parseInt(parts[2]);
                            Date bd = new Date(y - 1900, m - 1, d);
                            ok = addressBook.createPersonContact(name, phone, email, city, rel, nick, bd);
                        } catch (Exception ex) {
                            ok = false;
                        }
                    } else {
                        ok = false;
                    }

                } else if (t == 2) {
                    // Business extras
                    System.out.print("Website URL: ");
                    String url = input.nextLine().trim();
                    ok = addressBook.createBusinessContact(name, phone, email, city, url);

                } else if (t == 3) {
                    // Vendor extras
                    System.out.print("Industry: ");
                    String industry = input.nextLine().trim();
                    System.out.print("Vendor ID: ");
                    String id = input.nextLine().trim();
                    ok = addressBook.createVendorContact(name, phone, email, city, industry, id);

                } else if (t == 4) {
                    // Emergency extras
                    System.out.print("Priority level (int): ");
                    int p;
                    try {
                        p = Integer.parseInt(input.nextLine().trim());
                    } catch (Exception ex) {
                        p = 0;
                    }
                    ok = addressBook.createEmergencyContact(name, phone, email, city, p);

                }

                if (t != 5){
                    System.out.println(ok ? "\nContact added." : "\nAdd Contact failed, try again.");
                }

                //Pause menu
                pause(input);
                break;
            }

            case 2: {
                //"wipe" the screen
                System.out.println("\n \n \n \n \n");

                // Search, then choose how to proceed with the found contact
                System.out.println("Search by:\n 1.) Name\n 2.) Phone\n 3.) Email\n 4.) Back to Main Menu ");
                System.out.println("Enter search type: ");
                int s;
                try {
                    s = Integer.parseInt(input.nextLine().trim());
                } catch (Exception e) {
                    s = -1;
                }
                Contact found = null;

                if (s == 1) {
                    System.out.print("Name: ");
                    found = addressBook.searchName(input.nextLine().trim());
                } else if (s == 2) {
                    System.out.print("Phone: ");
                    found = addressBook.searchPhone(input.nextLine().trim());
                } else if (s == 3) {
                    System.out.print("Email: ");
                    found = addressBook.searchEmail(input.nextLine().trim());
                } else if(s == 4){
                    //Back to main menu option
                    break;
                } else {
                    System.out.println("Invalid search type.");
                }

                if (found == null) {
                    System.out.println("\nNo contact found.");
                } else {
                    System.out.println("\n \n \n \n \n");
                    int display_choice = 0;
                    do {
                        System.out.println(found.toString());
                        System.out.println("What would you like to do with this Contact?: ");
                        System.out.println(" 1.) Edit Contact ");
                        System.out.println(" 2.) Remove Contact ");
                        System.out.println(" 3.) Add or Remove Tag to Contact ");
                        System.out.println(" 4.) Back to previous menu ");
                        System.out.print("Enter choice: ");
                        display_choice = input.nextInt();
                        input.nextLine();

                        if (display_choice == 1) {
                            System.out.print("Enter new name: ");
                            String name = input.nextLine();

                            System.out.print("Enter new phone number: ");
                            String phoneNumber = input.nextLine();

                            System.out.print("Enter new email: ");
                            String email = input.nextLine();

                            System.out.print("Enter new city: ");
                            String city = input.nextLine();

                            found.setName(name);
                            found.setEmail(email);
                            found.setPhoneNumber(phoneNumber);
                            found.setCity(city);

                            System.out.println("\nUpdated contact successfully.");
                        } else if (display_choice == 2) {
                            addressBook.getContacts().remove(found);
                            System.out.println("\nRemoved contact successfully");
                            display_choice = 3;

                        } else if(display_choice == 3){
                            //Add or Remove Tag to found contact
                            System.out.println("\n\nTag Choice: ");
                            System.out.println("1.) Add Tag");
                            System.out.println("2.) Remove Tag");
                            System.out.println("3.) Back to Main Menu");
                            System.out.print("Enter choice: ");
                            int addOrRemoveTagchoice = input.nextInt();
                            input.nextLine();

                            if (addOrRemoveTagchoice == 1) {
                                System.out.print("Enter tag to add: ");
                                String tag = input.nextLine();
                                found.addTag(tag);
                                System.out.println("\nAdded tag successfully.");
                            } else if (addOrRemoveTagchoice == 2) {
                                System.out.print("Enter tag to remove: ");
                                String tag = input.nextLine();
                                found.removeTag(tag);
                                System.out.println("\nRemoved tag successfully");
                            } else if (addOrRemoveTagchoice == 2) {
                                //Return user to main menu
                                break;
                            } 
                            
                            else {
                                System.out.println("\nInvalid input, please try again.");
                            }

                        }else if(display_choice == 4){
                            //do nothing and pass through
                        }
                        else {
                            System.out.println("Invalid input.");
                        } 
                    } while (display_choice != 3);
                }

                //pause menu
                pause(input);
                break;
            }

            case 3: {
                //"wipe" the screen
                 System.out.println("\n \n \n \n \n");

                // List all contacts
                addressBook.displayAllContacts();

                //pause menu
                pause(input);
                break;
            }

            case 4: {
                //"wipe" the screen
                System.out.println("\n \n \n \n \n");


                // Filter menu
                System.out.println("Filter:\n 1.) Type\n 2.) City\n 3.) Tag\n ");
                System.out.println("Enter filter type: ");
                int f;
                try {
                    f = Integer.parseInt(input.nextLine().trim());
                } catch (Exception e) {
                    f = -1;
                }

                if (f == 1) {
                    System.out.println("Type:\n 1.) Person\n 2.) Business\n 3.) Vendor\n 4.) Emergency\n 5.) Back to Main Menu\n");
                    String ty = input.nextLine().trim();
                    addressBook.displayFiltered(addressBook.filterByType(ty));
                } else if (f == 2) {
                    System.out.println("City: ");
                    String ci = input.nextLine().trim();
                    addressBook.displayFiltered(addressBook.filterByCity(ci));
                } else if (f == 3) {
                    System.out.println("Enter tags separated by commas: ");
                    String lineTags = input.nextLine().trim();
                    ArrayList<String> tags = new ArrayList<>();
                    if (!lineTags.isEmpty()) {
                        for (String t2 : lineTags.split(",")) {
                            String sTag = t2.trim();
                            if (!sTag.isEmpty()) tags.add(sTag);
                        }
                    }
                    addressBook.displayFiltered(addressBook.filterByTags(tags));
                } else {
                    System.out.println("\nInvalid filter type.");
                }

                //pause menu
                pause(input);
                break;
            }

            case 5: {
                //"wipe" the screen
                System.out.println("\n \n \n \n \n");
                
                // Groups menu
                System.out.println("Groups:\n 1.) Create Group\n 2.) Add Contact to Group\n 3.) View all Group Summaries ");
                System.out.print("Enter Choice: ");
                int g;
                try {
                    g = Integer.parseInt(input.nextLine().trim());
                } catch (Exception e) {
                    g = -1;
                }

                if (g == 1) {
                    System.out.print("Group name: ");
                    String gname = input.nextLine().trim();
                    System.out.println(addressBook.createGroup(gname) ? "\nGroup created." : "\nCreate Group failed.");
                } else if (g == 2) {
                    System.out.print("Contact name: ");
                    String cname = input.nextLine().trim();
                    Contact c = addressBook.searchName(cname);
                    if (c == null) {
                        System.out.println("Contact not found.");
                        break;
                    }
                    System.out.print("Group name: ");
                    String gname = input.nextLine().trim();
                    System.out.println(addressBook.addContactToGroup(c, gname) ? "\nAdded to group." : "\nAdd failed.");
                } else if (g == 3) {
                    addressBook.groupSummary();
                } else {
                    System.out.println("\nInvalid Choice.");
                }

                //Pause menu
                pause(input);
                break;
            }

            case 6: {
                //Wipe Screen
                System.out.println("\n \n \n \n \n");

                // Reports
                addressBook.listPersonContacts();
                addressBook.listVendorContacts();
                addressBook.listBusinessContacts();
                addressBook.listEmergencyContacts();
                addressBook.listMissing();

                //Pause menu
                pause(input);
                break;
            }

            case 7: {
                // Exit
                System.out.println("\nExiting Address Book...");
                break;
            }

            default: {
                // Invalid number
                System.out.println("\nInvalid choice. Try again.");

                //pause menu
                pause(input);
                break;
            }
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

    private static void pause(Scanner input) {
        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }   
}

