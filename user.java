import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

//---------CLASS USER-----------
class User implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String username;
    private String password;
    private HashMap<String, Account> accounts = new HashMap<>();

    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String pass) {
        return password.equals(pass);
    }

    public void displayUser() {
        System.out.println("Username : " + username + " Password : [HIDDEN]");
    }

    // Add a new Account
    public void addAccount(String accountNumber) {
        if(accounts.containsKey(accountNumber)) {
            System.out.println("Account Already Exists!");
            return;
        }
        Account account = new Account(accountNumber);
        accounts.put(accountNumber, account);
        System.out.printn("Account Created Successfully!");
    }

    public void listAccounts() {
        if(accounts.isEmpty()) {
            System.out.println("No Accounts have been created yet.");
            return;
        }
        System.out.println("Your Accounts : ");
        for(String accountNumber : accounts.keySet()) {
            Account account = accounts.get(accountNumber);
            System.out.println("Account Number : " + accountNumber + " | Balance : " + account.getBalance());
        }
    }

    // Interact with a specific Account
    public void interactWithAccount() {
        if (accounts.isEmpty()) {
            System.out.println("You have no accounts to interact with.");
            return;
        } 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account Number : ");
        String accountNumber = scanner.nextLine();

        if(!accounts.containsKey(accountNumber)) {
            System.out.println("No Accounts found.");
            return;
        }

        Account account = accounts.get(accountNumber);

        System.out.println("1. Deposit : ");
        System.out.println("2. withDraw : ");
        System.out.println("Enter your choice : ");
        int choice = scanner.nextInt();

        System.out.println("Enter amount : ");
        double amount = scanner.nextDouble();
        

        switch(choice) {
            case 1 :
                account.deposit(amount);
                System.out.println("Current Balance : " + account.getBalance());
                break;

                case 2 :
                   if (account.withdraw(amount)) {
                    System.out.println("Current Balance : " + account.getBalance());
                    break;
                   } 
                   default :
                   System.out.println("Invalid choice!Try again:");
                   break;
        }
            
        
    }
}