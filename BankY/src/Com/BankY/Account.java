package Com.BankY;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	private List<String> transactionHistory;

	public Account(String accountNumber, String accountHolderName) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = 0.0;
		this.transactionHistory = new ArrayList<>();
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			transactionHistory.add("Deposited: " + amount);
		}
	}

	public boolean withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			transactionHistory.add("Withdrew: " + amount);
			return true;
		}
		return false;
	}

	public boolean transfer(double amount, Account targetAccount) {
		if (withdraw(amount)) {
			targetAccount.deposit(amount);
			transactionHistory.add("Transferred: " + amount + " to " + targetAccount.getAccountNumber());
			targetAccount.addTransaction("Received: " + amount + " from " + accountNumber);
			return true;
		}
		return false;
	}

	public void addTransaction(String transaction) {
		transactionHistory.add(transaction);
	}

	public double getBalance() {
		return balance;
	}

	public List<String> getTransactionHistory() {
		return transactionHistory;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}
}
