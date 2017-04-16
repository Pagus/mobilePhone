package telefon;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilephone = new MobilePhone("0039 330 4404");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        wyswietlMenu();
        while (!quit) {
            System.out.println("\nEnter action : (6 to show avaivaible actions) :");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    wyswietlMenu();
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (mobilephone.addNewContact(newContact)) {
            System.out.println("New contact added: " + name + ", phone = " + phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter the name of the contact which u want to update");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilephone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phonenumber: ");
        String newNumber = scanner.nextLine();
        Contact newContact = new Contact(newName, newNumber);
        if (mobilephone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record ");
        }

    }

    private static void removeContact() {
        System.out.println("Enter the name of the contact which u want to remove");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilephone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
        }
        if (mobilephone.removeContact(existingContactRecord)) {
            System.out.println("Succesfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilephone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
        }
        System.out.println("Name : " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }

    private static void printContacts() {
        mobilephone.printContacts();

    }

    private static void startPhone() {
        System.out.println("Włączanie telefonu ... ");
    }

    private static void wyswietlMenu() {
        System.out.println("Wybierz jedną z dostępnych opcji :");
        System.out.println("0 - Wyjdz");
        System.out.println("1 - Wyswietl dotępne kontakty");
        System.out.println("2 - Dodaj nowy kontakt");
        System.out.println("3 - Edytuj kontakt");
        System.out.println("4 - Usun kontakt");
        System.out.println("5 - Wyszukaj kontakt");
        System.out.println("6 - Wyswietl Menu");
        System.out.println("Choose your action : ");
    }

}
