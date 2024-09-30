package Com.BankY;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<String, Account> accounts;

	public Bank() {
		accounts = new HashMap<>();
	}

	public void createAccount(String accountHolderName) {
		String accountNumber = "ACC" + (accounts.size() + 1);
		accounts.put(accountNumber, new Account(accountNumber, accountHolderName));
	}

	public Account findAccount(String accountNumber) {
		return accounts.get(accountNumber);
	}

	public void saveToFile(String filename) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			for (Account account : accounts.values()) {
				writer.write(
						account.getAccountNumber() + "," + account.getAccountHolderName() + "," + account.getBalance());
				writer.newLine();
			}
		}
	}

	public void loadFromFile(String filename) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String accountNumber = parts[0];
				String accountHolderName = parts[1];
				double balance = Double.parseDouble(parts[2]);

				Account account = new Account(accountNumber, accountHolderName);
				account.deposit(balance); // Load the initial balance
				accounts.put(accountNumber, account);
			}
		}
	}
	public void listAccounts() {
		if(accounts.isEmpty()) {
			System.out.println("No accounts available!.");
		}else {
			System.out.println("Account List:");
            for (Account account : accounts.values()) {
                System.out.println("Account Number: " + account.getAccountNumber() + ", Holder: " + account.getAccountHolderName() + ", Balance: " + account.getBalance());
            }
		}
	}
}
