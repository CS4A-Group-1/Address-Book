import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

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

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.\n");
            return;
        }

        for (Contact c : contacts) {
            System.out.println("Name: " + c.getName());
            System.out.println("Phone: " + c.getPhoneNumber());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Type: " + c.getType());
            System.out.println("City: " + c.getCity());
            System.out.println("Tags: " + c.getTags());
            System.out.println("----------------------");
        }
    }
}
