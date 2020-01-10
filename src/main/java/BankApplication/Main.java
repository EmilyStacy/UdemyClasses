package BankApplication;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("my bank");
        bank.addBranch("LA");
        bank.addCustomer("Allie","LA",34.55);
        bank.addCustomer("Percy","LA",5.00);
        bank.addCustomer("Tim","LA",220.12);
        bank.addBranch("Dallas");
        bank.addCustomer("Sydney","Dallas",34.55);
       bank.addTransaction("Tim","LA",300.00);
       bank.addTransaction("Percy","LA",200.00);

        bank.listCustomers("LA",true);

    }
}
