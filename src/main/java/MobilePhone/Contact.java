package MobilePhone;

public class Contact {
    private String contactName;
    private String phoneNumber;

    public Contact(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }
    //calling constructor to create a new contact
    public static Contact createContact (String name, String phone){
        return new Contact(name,phone);
    }

    @Override
    public String toString() {
        return this.getContactName() + " " + this.getPhoneNumber();
    }
}
