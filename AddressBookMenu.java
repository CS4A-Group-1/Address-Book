import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMenu {
    AddressBook addressBook;

        AddressBookMenu(AddressBook addressBook){
            this.addressBook = addressBook;
        }

    public void groupSummary(ArrayList<Group> groups){
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

    public void listEmergencyContacts(ArrayList<Contact> contacts) {
        System.out.println("\n");

        System.out.println("---Emergency Contacts---");
        for (Contact c : contacts) {
            if (c instanceof Emergency) {
                System.out.println(c.toString());
            }
        }
    }

    public void listVendorContacts(ArrayList<Contact> contacts) {
        System.out.println("\n");

        System.out.println("---Vendor Contacts---");
        for (Contact c : contacts) {
            if (c instanceof Vendor) {
                System.out.println(c.toString());
            }
        }
    }

    public void listPersonContacts(ArrayList<Contact> contacts) {
         System.out.println("\n");

        System.out.println("---Person Contacts---");
        for (Contact c : contacts) {
            if (c instanceof Person) {
                System.out.println(c.toString());
            }
        }
    }

    public void listBusinessContacts(ArrayList<Contact> contacts) {
        System.out.println("\n");

        System.out.println("---Business Contacts---");
        for (Contact c : contacts) {
            if (c instanceof Business) {
                System.out.println(c.toString());
            }
        }
    }

    public void listMissing(ArrayList<Contact> contacts) {
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

    public void displayAllContacts(ArrayList<Contact> contacts) {
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

    public void displayFiltered(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts matched.");
        } else {
            for (Contact c : contacts) {
                System.out.println(c.toString());
            }
        }
    }

    public void displaySearch(Contact contact) {
            if (contact == null) {
                System.out.println("No contact found.");
            } else {
                System.out.println("Results: " + contact.toString());
            }
    }

    public void displayContact(Contact contact){
        System.out.println("Contact Info: ");
        System.out.println(contact.toString());
        System.out.println("---------------------");
    }



    public void manageContactPrompt(Contact contact){
        System.out.println("What would you like to do with this Contact?: ");
        System.out.println(" 1.) Edit Contact ");
        System.out.println(" 2.) Remove Contact ");
        System.out.println(" 3.) Add or Remove Tag to Contact ");
        System.out.println(" 4.) Back to previous menu ");
        System.out.print("Enter choice: ");

        // TODO: Finish
        // dont forget to call manageTags for 3.)

    }

    public void displayAddContactMenu(){ //case 1
        //

        

        // if else chain for 4 different types
        // addressBook.addContact()
    }

    public void searchContactMenu(){ //first half case 2
        //See case 2 in Main, copy top part mainly
    }

    public void displayByFilter(){ //case 4

    }

    public void displayGroupSummariesMenu(){
        
    }


    //Helper Functions for displayAddContactMenu
    private Person buildPersonContact(){
        //Prompt for each Attribute of the contact
        return contact;
    }

    private Person buildVendorContact(){
        //Prompt for each Attribute of the contact
        
        return contact;
    }    

    private Person buildBusinessContact(){
        //Prompt for each Attribute of the contact
        
        return contact;
    }

    private Person buildEmergencyContact(){
        //Prompt for each Attribute of the contact
        
        return contact;
    }

    public static void pause(Scanner input) {
        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }

    private ArrayList<Contact> manageTags(ArrayList<Contact> contacts) { // adding and removing tags
        Scanner input = new Scanner(System.in);
        System.out.print("Enter contact name: ");
        String name = input.nextLine();

        Contact c = addressBook.searchName(name);
        if (c == null) {
            System.out.println("Contact not found.");
            input.close();

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

        input.close();

        return contacts;
    }


}