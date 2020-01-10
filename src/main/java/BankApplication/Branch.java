package BankApplication;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return name;
    }

    public boolean createCustomer(String name, double initialAmount) {
        if(findCustomer(name) == null){
            this.customers.add(new Customer(name,initialAmount));
            return true;
        }
        return false;
    }

    private Customer findCustomer(String name) {
        for(int i=0; i <this.customers.size();i++){
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equals(name)){
                return checkedCustomer;
            }
        }
        return null;
    }

    public boolean addTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);
        if( existingCustomer!= null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public void updateTransaction(String name, double transaction){
        int positionFound = customers.indexOf(name);
        if(positionFound < 0){
            System.out.println("Customer not found. Transaction failed");
        }else{
            customers.get(positionFound).getTransactionList().add(Double.valueOf(transaction));
            System.out.println("Transaction success");
        }
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}