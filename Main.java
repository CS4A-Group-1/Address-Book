import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    
    

    //Note on how to build main:
    // try to nest scope within each case as little as possible. Sometimes it will be necessary, but try to keep the nesting really small. 
    // within a switch case, you should NEVER nest a loop. If any of these cases require nesting of a while/for/dowhile loop, then that functionality needs to go in its own function in this Main class.
    // an example of how a case should look are cases 3 & 6. thems are damn fine cases.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        AddressBookMenu addressBookMenu = new AddressBookMenu(addressBook);
        String choice = "0";

        while (choice != "7") {
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
                System.out.println("Groups:");
                System.out.println(" 1.) Create Group");
                System.out.println(" 2.) Add Contact to Group");
                System.out.println(" 3.) View all Group Summaries");
                System.out.println(" 4.) Back to Main Menu");
                System.out.print("Enter choice: ");

                String groupMenuChoice = input.nextLine().trim();
                 switch (groupMenuChoice) 
                 {
                    case "1": 
                    {
                        System.out.print("\nGroup name: ");
                        String groupName = input.nextLine().trim();
                        boolean created = addressBook.createGroup(groupName);
                        System.out.println(created ? "\nGroup created." : "\nCreate Group failed.");
                        break;
                    }
                    case "2": 
                    {
                        System.out.print("\nContact name: ");
                        String contactName = input.nextLine().trim();
                        Contact foundContact = addressBook.searchName(contactName);
                        if (foundContact == null) 
                        {
                            System.out.println("\nContact not found.");
                        } 
                        else 
                        {
                            System.out.print("Group name: ");
                            String targetGroupName = input.nextLine().trim();
                            boolean added = addressBook.addContactToGroup(foundContact, targetGroupName);
                            System.out.println(added ? "\nAdded to group." : "\nAdd failed.");
                        }
                        break;
                    }
                    case "3": 
                    {
                        ArrayList<Group> allGroups = addressBook.getGroups();
                        addressBookMenu.groupSummary(allGroups);
                        break;
                    }
                    case "4": 
                    {
                        break;
                    }
                    default: 
                    {
                        System.out.println("\nInvalid choice.");
                        break;
                    }
                }

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

