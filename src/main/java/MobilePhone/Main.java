package MobilePhone;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static Mobile mobile = new Mobile("0000000000");
    public static void main(String[] args) {
        boolean quit = false;
    startPhone();
    printInstructions();
    while(!quit){
        System.out.println("\n Enter action");
        int action = scanner.nextInt();
        scanner.nextLine();
        switch(action){
            case 0:
                System.out.println("\n shutting down");
                quit = true;
                break;

            case 1:
                mobile.printOutArray();
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
                printInstructions();
                break;

        }
    }


    }

    private static void queryContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobile.queryContact(name);
        if(existingContact == null){
            System.out.println("contact not found");
            return;
        }
        System.out.println(existingContact.toString());

    }

    private static void removeContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobile.queryContact(name);
        if(existingContact == null){
            System.out.println("contact not found");
            return;
        }
        if(mobile.removeContact(existingContact)){
            System.out.println("Successfully deleted");
        }else{
            System.out.println("Error deleted");
        }

    }

    private static void updateContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobile.queryContact(name);
        if(existingContact == null){
            System.out.println("contact not found");
            return;
        }
        System.out.println("Enter new Contact name: ");
        String newname = scanner.nextLine();
        System.out.println("Enter new contact number");
        String newNum = scanner.nextLine();
        Contact newContact = Contact.createContact(newname, newNum);
        if(mobile.updateContact(existingContact,newContact)){
            System.out.println("Successfully update the record");
        }else{
            System.out.println("Error updating records");
        }
    }



    private static void addNewContact() {
        System.out.println("Enter new contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        Contact contact = Contact.createContact(name,phoneNumber);
        if(mobile.addNewContact(contact)){
            System.out.println("new contact added:" + contact.toString());
        }else{
            System.out.println("cannot add" + name + "already on file");
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone ...");
    }


    public static void printInstructions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println(
                "0: shut down\n" +
                "1: print contacts\n" +
                "2: add new contact\n" +
                "3: updating an existing contact\n" +
                "4: remove an existing contact\n" +
                "5: query if an existing contact exist \n" +
                        "6:print the list of actions"
                );
        System.out.println("Choose your option: ");
    }


    public void addContact(String username, long num){
        System.out.println("Enter the user name");
        username = scanner.next();
        scanner.nextLine();
        num = scanner.nextLong();
        scanner.nextLine();


    }




}
