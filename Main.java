import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    
    
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

                    //     int display_choice = 0;
                    //     do {
                    //         System.out.println(found.toString());
                    //         System.out.println("What would you like to do with this Contact?: ");
                    //         System.out.println(" 1.) Edit Contact ");
                    //         System.out.println(" 2.) Remove Contact ");
                    //         System.out.println(" 3.) Add or Remove Tag to Contact ");
                    //         System.out.println(" 4.) Back to previous menu ");
                    //         System.out.print("Enter choice: ");

                    //         // Safely read numeric input
                    //         if (!input.hasNextInt()) {
                    //             System.out.println("Invalid input, please enter a number.");
                    //             input.nextLine(); // clear invalid input
                    //             continue;
                    //         }

                    //         display_choice = input.nextInt();
                    //         input.nextLine(); // clear newline

                    //         if (display_choice == 1) {
                    //             System.out.print("Enter new name: ");
                    //             String name = input.nextLine();

                    //             System.out.print("Enter new phone number: ");
                    //             String phoneNumber = input.nextLine();

                    //             System.out.print("Enter new email: ");
                    //             String email = input.nextLine();

                    //             System.out.print("Enter new city: ");
                    //             String city = input.nextLine();

                    //             found.setName(name);
                    //             found.setEmail(email);
                    //             found.setPhoneNumber(phoneNumber);
                    //             found.setCity(city);

                    //             System.out.println("\nUpdated contact successfully.");

                    //         } else if (display_choice == 2) {
                    //             // safer to call a remove method than modifying the list directly
                    //             addressBook.getContacts().remove(found);
                    //             System.out.println("\nRemoved contact successfully");
                    //             break;

                    //         } else if (display_choice == 3) {
                    //             System.out.println("\n\nTag Choice: ");
                    //             System.out.println(" 1.) Add Tag");
                    //             System.out.println(" 2.) Remove Tag");
                    //             System.out.println(" 3.) Back to Previous Menu");
                    //             System.out.print("Enter choice: ");

                    //             if (!input.hasNextInt()) {
                    //                 System.out.println("Invalid input, please enter a number.");
                    //                 input.nextLine();
                    //                 continue;
                    //             }

                    //             int addOrRemoveTagChoice = input.nextInt();
                    //             input.nextLine();

                    //             if (addOrRemoveTagChoice == 1) {
                    //                 System.out.print("Enter tag to add: ");
                    //                 String tag = input.nextLine();
                    //                 found.addTag(tag);
                    //                 System.out.println("\nAdded tag successfully.");

                    //             } else if (addOrRemoveTagChoice == 2) {
                    //                 System.out.print("Enter tag to remove: ");
                    //                 String tag = input.nextLine();
                    //                 found.removeTag(tag);
                    //                 System.out.println("\nRemoved tag successfully.");

                    //             } else if (addOrRemoveTagChoice != 3) {
                    //                 System.out.println("\nInvalid input, please try again.");
                    //             }

                    //         } else if (display_choice != 4) {
                    //             System.out.println("Invalid input.");
                    //         }

                    //     } while (display_choice != 4);
                    // }

                    //pause menu
                    AddressBookMenu.pause(input);
                    break;
                }

                case "3": {
                    //"wipe" the screen
                    System.out.println("\n \n \n \n \n");

                    ArrayList<Contact> reportContacts = addressBook.getContacts();
                    // List all contacts
                    addressBookMenu.displayAllContacts(reportContacts);

                    //pause menu
                    AddressBookMenu.pause(input);
                    break;
                }

                case "4": {
                    // //"wipe" the screen
                    // System.out.println("\n \n \n \n \n");


                    // // Filter menu
                    // System.out.println("Filter:\n 1.) Type\n 2.) City\n 3.) Tag\n 4.) Back to Main Menu");
                    // System.out.println("Enter filter type: ");
                    // int f;
                    // try {
                    //     f = Integer.parseInt(input.nextLine().trim());
                    // } catch (Exception e) {
                    //     f = -1;
                    // }

                    // if (f == 1) {
                    //     System.out.println("Type:\n 1.) Person\n 2.) Business\n 3.) Vendor\n 4.) Emergency\n ");
                    //     String ty = input.nextLine().trim();

                    //     addressBook.displayFiltered(addressBook.filterByType(ty));
                    // } else if (f == 2) {
                    //     System.out.println("City: ");
                    //     String ci = input.nextLine().trim();
                    //     addressBook.displayFiltered(addressBook.filterByCity(ci));
                    // } else if (f == 3) {
                    //     System.out.println("Enter tags separated by commas: ");
                    //     String lineTags = input.nextLine().trim();
                    //     ArrayList<String> tags = new ArrayList<>();
                    //     if (!lineTags.isEmpty()) {
                    //         for (String t2 : lineTags.split(",")) {
                    //             String sTag = t2.trim();
                    //             if (!sTag.isEmpty()) tags.add(sTag);
                    //         }
                    //     }
                    //     addressBook.displayFiltered(addressBook.filterByTags(tags));
                    // } else if( f == 4){
                    //     //Do nothing and pass through
                    // } else {
                    //     System.out.println("\nInvalid filter type.");
                    // }

                    //pause menu
                    AddressBookMenu.pause(input);
                    break;
                }

                case "5": {
                    // //"wipe" the screen
                    // System.out.println("\n \n \n \n \n");
                    
                    // // Groups menu
                    // System.out.println("Groups:\n 1.) Create Group\n 2.) Add Contact to Group\n 3.) View all Group Summaries ");
                    // System.out.print("Enter Choice: ");
                    // int g;
                    // try {
                    //     g = Integer.parseInt(input.nextLine().trim());
                    // } catch (Exception e) {
                    //     g = -1;
                    // }

                    // if (g == 1) {
                    //     System.out.print("Group name: ");
                    //     String gname = input.nextLine().trim();
                    //     System.out.println(addressBook.createGroup(gname) ? "\nGroup created." : "\nCreate Group failed.");
                    // } else if (g == 2) {
                    //     System.out.print("Contact name: ");
                    //     String cname = input.nextLine().trim();
                    //     Contact c = addressBook.searchName(cname);
                    //     if (c == null) {
                    //         System.out.println("Contact not found.");
                    //         break;
                    //     }
                    //     System.out.print("Group name: ");
                    //     String gname = input.nextLine().trim();
                    //     System.out.println(addressBook.addContactToGroup(c, gname) ? "\nAdded to group." : "\nAdd failed.");
                    // } else if (g == 3) {
                    //     addressBook.groupSummary();
                    // } else {
                    //     System.out.println("\nInvalid Choice.");
                    // }

                    //Pause menu
                    AddressBookMenu.pause(input);
                    break;
                }

                case "6": {
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

                case "7": {
                    // Exit
                    System.out.println("\nExiting Address Book...");
                    break;
                }

                default: {
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
