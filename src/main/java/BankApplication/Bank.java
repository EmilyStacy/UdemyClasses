package BankApplication;

import java.util.ArrayList;

public class Bank {
private String name;
private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
//add a new Branch
    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }
//find branch
    private Branch findBranch(String branchName) {
        for(int i=0; i <this.branches.size();i++){
            Branch checkedbranch = this.branches.get(i);
            if(checkedbranch.getBranchName().equals(branchName)){
                return checkedbranch;
            }
        }
        return null;

    }
//add a customer to the branch with initial transaction
    public boolean addCustomer(String customerName, String branchName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch !=null){
            return branch.createCustomer(customerName, initialAmount);
        }
        return false;
    }
  //add transaction
  public boolean addTransaction(String customerName, String branchName, double initialAmount){
      Branch branch = findBranch(branchName);
      if(branch !=null){
          return branch.addTransaction(customerName, initialAmount);
      }
      return false;
  }
//show a list of customer to a specific branch
public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if(branch !=null){
            System.out.println("Customer details for branch " + branch.getBranchName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i=0;i<branchCustomers.size();i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer" + branchCustomer.getName() + "[ " + (i+1) + "]");
                if(showTransactions){
                    System.out.println("Transactions: " );
                    ArrayList<Double> transactions = branchCustomer.getTransactionList();
                    for(int j=0; j<transactions.size();j++){
                        System.out.println("[ " + (j+1) + "]" +" amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
}


}
