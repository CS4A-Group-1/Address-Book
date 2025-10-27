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
                    // System.out.println("\n \n \n \n \n");

                    // // Add contact by type
                    // System.out.println("Type:\n 1.) Person\n 2.) Business\n 3.) Vendor\n 4.) Emergency\n 5.) Back to Main Menu ");
                    // System.out.print("Enter type: ");
                    // int t;
                    // try {
                    //     t = Integer.parseInt(input.nextLine().trim());
                    // } catch (Exception e) {
                    //     t = -1;
                    // }

                    // //input check/back to main menu
                    // boolean isInvalidInput = t < 1 || t > 5;
                    // if (isInvalidInput){
                    //     //tell the user their input is invalid and tell them to try again with a pause.
                    //     System.out.println("\nInvalid input, try again.");
                    //     pause(input);
                    //     break;
                    // } 

                    // //go back to main menu
                    // if (t == 5){
                    //     break;
                    // } 

                    // // Common fields
                    // System.out.print("Name: ");
                    // String name = input.nextLine().trim();
                    // System.out.print("Phone: ");
                    // String phone = input.nextLine().trim();
                    // System.out.print("Email: ");
                    // String email = input.nextLine().trim();
                    // System.out.print("City: ");
                    // String city = input.nextLine().trim();

                    // boolean ok = false;

                    // if (t == 1) {
                    //     // Person extras
                    //     System.out.print("Relationship: ");
                    //     String rel = input.nextLine().trim();
                    //     System.out.print("Nickname: ");
                    //     String nick = input.nextLine().trim();

                    //     // Birthday in mm dd yyyy, also accepts mm/dd/yyyy or mm-dd-yyyy
                    //     System.out.print("Birthday mm dd yyyy: ");
                    //     String b = input.nextLine().trim().replace('-', ' ').replace('/', ' ');
                    //     String[] parts = b.split("\\s+");
                    //     if (parts.length == 3) {
                    //         try {
                    //             int m = Integer.parseInt(parts[0]);
                    //             int d = Integer.parseInt(parts[1]);
                    //             int y = Integer.parseInt(parts[2]);
                    //             Date bd = new Date(y - 1900, m - 1, d);
                    //             ok = addressBook.createPersonContact(name, phone, email, city, rel, nick, bd);
                    //         } catch (Exception ex) {
                    //             ok = false;
                    //         }
                    //     } else {
                    //         ok = false;
                    //     }

                    // } else if (t == 2) {
                    //     // Business extras
                    //     System.out.print("Website URL: ");
                    //     String url = input.nextLine().trim();
                    //     ok = addressBook.createBusinessContact(name, phone, email, city, url);

                    // } else if (t == 3) {
                    //     // Vendor extras
                    //     System.out.print("Industry: ");
                    //     String industry = input.nextLine().trim();
                    //     System.out.print("Vendor ID: ");
                    //     String id = input.nextLine().trim();
                    //     ok = addressBook.createVendorContact(name, phone, email, city, industry, id);

                    // } else if (t == 4) {
                    //     // Emergency extras
                    //     System.out.print("Priority level (int): ");
                    //     int p;
                    //     try {
                    //         p = Integer.parseInt(input.nextLine().trim());
                    //     } catch (Exception ex) {
                    //         p = 0;
                    //     }
                    //     ok = addressBook.createEmergencyContact(name, phone, email, city, p);

                    // }

                    // if (t != 5){
                    //     System.out.println(ok ? "\nContact added." : "\nAdd Contact failed, try again.");
                    // }

                    //Pause menu
                    AddressBookMenu.pause(input);
                    break;
                }

                case "2": {
                    // //"wipe" the screen
                    // System.out.println("\n \n \n \n \n");

                    // // Search, then choose how to proceed with the found contact
                    // System.out.println("Search by:\n 1.) Name\n 2.) Phone\n 3.) Email\n 4.) Back to Main Menu ");
                    // System.out.println("Enter search type: ");
                    // int s;
                    // try {
                    //     s = Integer.parseInt(input.nextLine().trim());
                    // } catch (Exception e) {
                    //     s = -1;
                    // }
                    // Contact found = null;

                    // if (s == 1) {
                    //     System.out.print("Name: ");
                    //     found = addressBook.searchName(input.nextLine().trim());
                    // } else if (s == 2) {
                    //     System.out.print("Phone: ");
                    //     found = addressBook.searchPhone(input.nextLine().trim());
                    // } else if (s == 3) {
                    //     System.out.print("Email: ");
                    //     found = addressBook.searchEmail(input.nextLine().trim());
                    // } else if(s == 4){
                    //     //Back to main menu option
                    //     break;
                    // } else {
                    //     System.out.println("Invalid search type.");
                    // }

                    // if (found == null) {
                    //     System.out.println("\nNo contact found.");
                    // } else {
                    //     System.out.println("\n\n\n\n\n");

                    //    manageContactPrompt()
                    //     
                    // }

                    //pause menu
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
