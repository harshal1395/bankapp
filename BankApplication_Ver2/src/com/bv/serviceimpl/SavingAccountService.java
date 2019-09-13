package com.bv.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.bv.model.Account;
import com.bv.model.SavingAccount;
import com.bv.service.ITransaction;
import com.messageservice.InsufficientBalanceException;
import com.messageservice.NegativeBalanceException;

public class SavingAccountService implements ITransaction {

	SavingAccount savingAccount;
	LocalTime time=LocalTime.now();
	LocalDate date=LocalDate.now();
	public SavingAccountService(Account savingAccount) {
		super();
		this.savingAccount = (SavingAccount) savingAccount;
		if (!((SavingAccount) savingAccount).isSalaryAccount()) {
			set();
		} 
	}

	public static void setAccountType(SavingAccount savingAccount)
	{
		if (!((SavingAccount) savingAccount).isSalaryAccount()) {
			savingAccount.setAcc_type("Saving");
		} else {
			savingAccount.setAcc_type("Salary");
		}
	}
	private void set() {

		savingAccount.setLimit_charges(100);
		savingAccount.setMin_balance(1000);
	}

	@Override
	public void withdraw(double amount) {

		System.out.println("Before withdraw:" + savingAccount.getBalance());
		if (amount < 0) {
			System.out.println("\n" + "------------------------SMS-------------------------------");
			try {
				throw new NegativeBalanceException("Invalid Transaction amount cannot be negative");
			} catch (NegativeBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (savingAccount.getBalance() < amount) {
			System.out.println("\n" + "------------------------SMS-------------------------------");
			try {
				throw new InsufficientBalanceException("Insufficient fund balance");
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			savingAccount.setBalance(savingAccount.getBalance() - amount);
			System.out.println("\n" + "------------------------SMS-------------------------------");
			System.out.println(
					"Your account XXXXXXX" + savingAccount.getAcc_no() % 10 + " has been debited with Rs." + amount+"On "+date+"  "+time);
			if (savingAccount.getBalance() - savingAccount.getLimit_charges() > 0
					&& savingAccount.isSalaryAccount() == false) {
				if (savingAccount.getBalance() < savingAccount.getMin_balance()) {
					savingAccount.setBalance(savingAccount.getBalance() - savingAccount.getLimit_charges());
					System.out.println(
							"Chargers applied for not maintining min balance: " + savingAccount.getLimit_charges());
				}
			} else if (savingAccount.isSalaryAccount() == false) {
				System.out.println("Limit charges of " + savingAccount.getLimit_charges()
						+ " rs will be debited in next transaction");
				savingAccount.setBalance(savingAccount.getBalance() - savingAccount.getLimit_charges());
			}

			if (savingAccount.getBalance() < 0)
				System.out.println("and Your account balance is " + 0.0);
			else
				System.out.println("and Your account balance is " + savingAccount.getBalance());

		}
	}

	@Override
	public void deposite(double amount) {

		// System.out.println("Before Depoite: " + savingAccount.getBalance());
		savingAccount.setBalance(savingAccount.getBalance() + amount);
		System.out.println("\n" + "---------------------------SMS----------------------------");
		System.out.println(
				"Your account XXXXXXX" + savingAccount.getAcc_no() % 10 + " has been credited with Rs." + amount);
		System.out.println("and Your account balance is " + savingAccount.getBalance());
	}

	public void chooseOperation() {
		Scanner sc = null;
		int choice;
		boolean flag = true;
		while (flag) {

			System.out.println("\n" + "Select one of the options below");
			System.out.println("1. Withdraw" + "\n" + "2. Deposite" + "\n" + "3. Display Details" + "\n" + "4. Exit"+"\n");
			sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter amount to be withdraw"+"\n");
				withdraw(sc.nextDouble());
				break;
			}

			case 2: {
				System.out.println("Enter amount to be deposite"+"\n");
				deposite(sc.nextDouble());
				break;
			}
			case 3: {
				System.out.println(savingAccount);
				break;
			}
			case 4: {
				System.out.println("Transaction complete\n");
				flag = false;
				break;
			}
			default: {
				System.out.println("Enter Valid operation"+"\n");
				break;
			}
			}

		}

	}

}
