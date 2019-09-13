package com.bv.serviceimpl;

import java.util.Scanner;

import com.bv.model.Account;
import com.bv.model.CurrentAccount;
import com.bv.service.ITransaction;

public class CurrentAccountService implements ITransaction{

	CurrentAccount currentAccount;
	static double originalCreditLimit;
	public CurrentAccountService(Account account) {
		super();
		this.currentAccount = (CurrentAccount) account;
		
		
	}

	public static void setAccountType(CurrentAccount currentAccount)
	{
		currentAccount.setAcc_type("Current");
		currentAccount.setCreditLimit(50000);
		originalCreditLimit=currentAccount.getCreditLimit();
	}
	/*public void set()
	{
		currentAccount.setCreditLimit(50000);
		originalCreditLimit=currentAccount.getCreditLimit();
	}*/
	
	@Override
	public void withdraw(double amount) {
		double balance=currentAccount.getBalance()-amount;
		double creditLimit=currentAccount.getCreditLimit();
		if (balance >= 0)
		{
			currentAccount.setBalance(balance);
			System.out.println("Your account XXXXXXX" + currentAccount.getAcc_no() % 10 + " has been debited with Rs." + amount);
			System.out.println("and Your account balance is " + currentAccount.getBalance() +"\n"+"And your credit limit is "+currentAccount.getCreditLimit());
		}
		else if (balance+creditLimit >= 0)
		{
			currentAccount.setBalance(balance);
			currentAccount.setCreditLimit(creditLimit+balance);
			System.out.println("Your account XXXXXXX" + currentAccount.getAcc_no() % 10 + " has been debited with Rs." + amount);
			System.out.println("and Your account balance is " + currentAccount.getBalance()+"\n"+"And your credit limit is "+currentAccount.getCreditLimit());
		}
		else
		{
			System.out.println("Transaction declined because you exceed credit limit");
			System.out.println("You can maximum withdraw upto Rs. "+(currentAccount.getBalance()+creditLimit));
			
		}
			
		
			
	}

	@Override
	public void deposite(double amount) {
		
		if (currentAccount.getBalance() < 0)
		{
			double bal=currentAccount.getCreditLimit()+amount-originalCreditLimit;
			currentAccount.setCreditLimit(originalCreditLimit);
			currentAccount.setBalance(bal);
			System.out.println("Your account XXXXXXX" + currentAccount.getAcc_no() % 10 + " has been credited with Rs." + amount);
			System.out.println("and Your account balance is " + currentAccount.getBalance() +"\n"+"And your credit limit is "+currentAccount.getCreditLimit());
		}
		else
		{
			currentAccount.setBalance(amount);
			System.out.println("Your account XXXXXXX" + currentAccount.getAcc_no() % 10 + " has been credited with Rs." + amount);
			System.out.println("and Your account balance is " + currentAccount.getBalance() +"\n"+"And your credit limit is "+currentAccount.getCreditLimit());
			
		}
		
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
				System.out.println(currentAccount);
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
