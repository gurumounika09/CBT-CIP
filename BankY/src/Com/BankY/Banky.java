package Com.BankY;

import java.io.IOException;
import java.util.Scanner;

public class Banky {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner scanner = new Scanner(System.in);
		String filename = "accounts.txt";

		// Load existing accounts
		try {
			bank.loadFromFile(filename);
		} catch (IOException e) {
			System.out.println("No existing accounts found.");
		}

		while (true) {
			System.out.println("1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Transfer");
			System.out.println("5. View Balance");
			System.out.println("6. List Accounts");
			System.out.println("7. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
//				System.out.println("Enter account number: ");
//				long accountNo = scanner.nextLong();
				System.out.print("Enter account holder name: ");
				String name = scanner.nextLine();
				bank.createAccount(name);
				System.out.println("Account created successfully!");
				break;
			case 2:
				System.out.print("Enter account number: ");
				String accNumDeposit = scanner.nextLine();
				Account accountDeposit = bank.findAccount(accNumDeposit);
				if (accountDeposit != null) {
					System.out.print("Enter amount to deposit: ");
					double depositAmount = scanner.nextDouble();
					accountDeposit.deposit(depositAmount);
					System.out.println("Deposit successful!");
				} else {
					System.out.println("Account not found.");
				}
				break;
			case 3:
				System.out.print("Enter account number: ");
				String accNumWithdraw = scanner.nextLine();
				Account accountWithdraw = bank.findAccount(accNumWithdraw);
				if (accountWithdraw != null) {
					System.out.print("Enter amount to withdraw: ");
					double withdrawAmount = scanner.nextDouble();
					if (accountWithdraw.withdraw(withdrawAmount)) {
						System.out.println("Withdrawal successful!");
					} else {
						System.out.println("Insufficient funds.");
					}
				} else {
					System.out.println("Account not found.");
				}
				break;
			case 4:
				System.out.print("Enter your account number: ");
				String accNumFrom = scanner.nextLine();
				Account accountFrom = bank.findAccount(accNumFrom);
				if (accountFrom != null) {
					System.out.print("Enter target account number: ");
					String accNumTo = scanner.nextLine();
					Account accountTo = bank.findAccount(accNumTo);
					if (accountTo != null) {
						System.out.print("Enter amount to transfer: ");
						double transferAmount = scanner.nextDouble();
						if (accountFrom.transfer(transferAmount, accountTo)) {
							System.out.println("Transfer successful!");
						} else {
							System.out.println("Transfer failed.");
						}
					} else {
						System.out.println("Target account not found.");
					}
				} else {
					System.out.println("Your account not found.");
				}
				break;
			case 5:
				System.out.print("Enter account number: ");
				String accNumBalance = scanner.nextLine();
				Account accountBalance = bank.findAccount(accNumBalance);
				if (accountBalance != null) {
					System.out.println("Balance: " + accountBalance.getBalance());
				} else {
					System.out.println("Account not found.");
				}
				break;
			case 6: 
				bank.listAccounts();
				break;
			case 7:
				// Save accounts to file
				try {
					bank.saveToFile(filename);
				} catch (IOException e) {
					System.out.println("Error saving accounts.");
				}
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
}
