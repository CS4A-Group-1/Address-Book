import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        AddressBookMenu addressBookMenu = new AddressBookMenu(addressBook);
        String choice = "0";

        while (!"7".equals(choice)) {
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
            choice = input.nextLine();
            //

            //Dont case by int, instead you should case by a string of the number. IE case: "1", case "2".
            switch (choice) {

                case "1": {
                    // //"wipe" the screen
                    System.out.println("\n \n \n \n \n");
                    addressBookMenu.displayAddContactMenu();
                    AddressBookMenu.pause(input);
                    break;
                }

                case "2": {
                    // //"wipe" the screen
                    System.out.println("\n \n \n \n \n");
                    addressBookMenu.searchContactMenu();
                    AddressBookMenu.pause(input);
                    break;
                }

                case "3": 
                {
                    //"wipe" the screen
                    System.out.println("\n \n \n \n \n");

                    ArrayList<Contact> reportContacts = addressBook.getContacts();
                    // List all contacts
                    addressBookMenu.displayAllContacts(reportContacts);

                    //pause menu
                    AddressBookMenu.pause(input);
                    break;
                }

                case "4": 
                {
                    System.out.println("\n\n\n\n\n");
                    addressBookMenu.displayByFilter();
                    //pause menu
                    AddressBookMenu.pause(input);
                    break;
                }

                case "5": 
                {
                    System.out.println("\n\n\n\n\n");

                    addressBookMenu.manageGroupsMenu();

                    AddressBookMenu.pause(input);
                    break;
                }

                case "6": 
                {
                    //Wipe Screen
                    System.out.println("\n \n \n \n \n");

                    ArrayList<Contact> reportContacts = addressBook.getContacts();
                    // Reports
                    addressBookMenu.listPersonContacts(reportContacts);
                    addressBookMenu.listVendorContacts(reportContacts);
                    addressBookMenu.listBusinessContacts(reportContacts);
                    addressBookMenu.listEmergencyContacts(reportContacts);
                    addressBookMenu.listMissing(reportContacts);

                    //Pause menu
                    AddressBookMenu.pause(input);
                    break;
                }

                case "7": 
                {
                    // Exit
                    System.out.println("\nExiting Address Book...");
                    break;
                }

                default: 
                {
                    // Invalid number
                    System.out.println("\nInvalid choice. Try again.");

                    //pause menu
                    AddressBookMenu.pause(input);
                    break;
                }
            }

            System.out.println();
        }

        input.close();
    }




}

