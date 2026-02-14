import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

// --------ACCOUNT CLASS---------
class Account implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String accountNumber;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    } 

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("INVALID AMOUNT!");
        }
    }
 public boolean withDraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        System.out.println("Withdraw Successful!");
        return true;
    } else {
        System.out.println("Insufficent Funds!");
        return false;
    }
 }

 public displayAccount() {
    System.out.println("Account Number : " + accountNumber + " | Balance : " + balance);
 }
}