package MobilePhone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Mobile {
    private String myNumber;
    private ArrayList<Contact> contactList;

    public Mobile(String myNumber) {
        this.myNumber = myNumber;
        this.contactList = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getContactName()) >=0){
            System.out.println("Contact already exists");
            return false;
        }
        contactList.add(contact);
        return true;
        
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition <0){
            System.out.println(oldContact.getContactName() + " was not found.");
            return false;
        }else if(findContact(newContact.getContactName()) != -1){
            System.out.println("Contact with name " + newContact.getContactName() + " already exists." );
            return false;
        }
        this.contactList.set(foundPosition, newContact);
        System.out.println();
        return true;
    }
    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition <0){
            System.out.println(contact.getContactName() + " was not found.");
            return false;
        }
        this.contactList.remove(foundPosition);
        System.out.println(contact.getContactName() + " " + " was deleted");
        return true;

    }
    public String queryContact(Contact contact){
        if (findContact(contact) >=0){
            return contact.getContactName();
        }
        return null;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if (position >=0){
            return this.contactList.get(position);
        }
        return null;
    }
    private int findContact(Contact contact) {
        return this.contactList.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i=0; i<this.contactList.size();i++){
            Contact contact = this.contactList.get(i);
            if (contact.getContactName().equals(contactName)){
                return i;
            }

        }
        return -1;
    }

    public void printOutArray(){
        for(Contact contact:this.contactList){
            System.out.println(contact.toString());
        }
    }
}
