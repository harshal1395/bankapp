package com.bv.serviceimpl;

import java.util.Scanner;

import com.bv.model.Account;

public class AccountService {

	private CurrentAccountRepository currentAccountRepository;
	private SavingAccountsRepository savingAccountsRepository;
	SavingAccountService savingAccountService;
	CurrentAccountService currentAccountService;
	Account account;
	

	public AccountService() {
		super();
		this.currentAccountRepository = new CurrentAccountRepository();
		this.savingAccountsRepository = new SavingAccountsRepository();
	}


	/*public AccountService(Account account) {
		super();
		this.account = account;
		if (account instanceof SavingAccount)
			savingAccountService = new SavingAccountService(account);
		else
			currentAccountService = new CurrentAccountService(account);
		;
	}*/

	public void chooseAccount() {
		Scanner sc = null;
		int choice;
		boolean flag = true;
		while (flag) {

			System.out.println("\n" + "Select one of the options below");
			System.out.println("1. Saving" + "\n" + "2. Current" + "\n");
			sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter your account number\n");
				savingAccountService = new SavingAccountService(savingAccountsRepository.getAccount(sc.nextInt()));
				savingAccountService.chooseOperation();
				flag=false;
				break;
			}

			case 2: {
				System.out.println("Enter your account number\n");
				currentAccountService=new CurrentAccountService(currentAccountRepository.getAccount(sc.nextInt()));
				currentAccountService.chooseOperation();
				flag=false;
				break;
			}
			default: {
				System.out.println("Enter Valid Account"+"\n");
				break;
			}
			}
		}
	}
}

/*SavingAccount savingAccount=new SavingAccount();
				System.out.println("Enter your Saving account number : "+"\n");
				savingAccount.setAcc_no(sc.nextInt());
				System.out.println("Enter your Name : "+"\n");
				System.out.println("Is your account is salary account : "+"\n"+"1. YES "+"\n2. NO"+"\n");
				int select=0;
				switch (select) {
				case 1: {savingAccount.settrue;
				}
				case 2: {
				}
				}*/