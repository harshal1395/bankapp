package com.bv.serviceimpl;

import java.util.Scanner;

import com.bv.model.SalaryAccount;
import com.bv.service.ITransaction;
import com.messageservice.*;

public class SalaryAccountService implements ITransaction {
	SalaryAccount salaryAccount;
	

	public SalaryAccountService(SalaryAccount salaryAccount) {
		super();
		this.salaryAccount = salaryAccount;
	}

	@Override
	public void withdraw(double amount) {
		//System.out.println("Before withdraw:" + salaryAccount.getBalance());
		if (amount < 0) {
			System.out.println("\n" + "------------------------SMS-------------------------------");
			try {
				throw new NegativeBalanceException("Invalid Transaction amount cannot be negative");
			} catch (NegativeBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (salaryAccount.getBalance() < amount) {
			System.out.println("\n" + "------------------------SMS-------------------------------");
			try {
				throw new InsufficientBalanceException("Insufficient fund balance");
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			salaryAccount.setBalance(salaryAccount.getBalance() - amount);
			System.out.println("\n" + "------------------------SMS-------------------------------");
			System.out.println("Your account XXXXXXX" + salaryAccount.getAcc_no()%10 + " has been debited with Rs." + amount);
			System.out.println("and Your account balance is " + salaryAccount.getBalance());
		}

	}

	@Override
	public void deposite(double amount) {

		//System.out.println("Before Depoite: " + salaryAccount.getBalance());
		salaryAccount.setBalance(salaryAccount.getBalance() + amount);
		System.out.println("\n" + "---------------------------SMS----------------------------");
		System.out.println("Your account XXXXXXX" + salaryAccount.getAcc_no()%10 + " has been credited with Rs." + amount);
		System.out.println("and Your account balance is " + salaryAccount.getBalance());

	}
	
	public void chooseOperation() {
		Scanner sc = null;
		int choice;
		boolean flag = true;
			while (flag) {

				System.out.println("\n" + "Select one of the options below");
				System.out
						.println("1. Withdraw" + "\n" + "2. Deposite" + "\n" + "3. Display Details" + "\n" + "4. Exit");
				sc = new Scanner(System.in);
				choice = sc.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Enter amount to be withdraw");
					withdraw(sc.nextDouble());
					break;
				}

				case 2: {
					System.out.println("Enter amount to be deposite");
					deposite(sc.nextDouble());
					break;
				}
				case 3:
					System.out.println("Acco no: "+salaryAccount.getAcc_no());
					System.out.println("Holder name: "+salaryAccount.getHolder_name());
					System.out.println("Balance: "+salaryAccount.getBalance());
					break;

				case 4: {
					System.out.println("Transaction complete");
					flag = false;
					break;
				}
				default: {
					System.out.println("Enter Valid operation");
					break;
				}
				}

			}
	
	}


}
