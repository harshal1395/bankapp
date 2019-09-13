package com.bv.execution;

import com.bv.serviceimpl.AccountService;

public class BankApp {

	public static void main(String[] args) {
		
		/*Account salAccount = new SavingAccount(102, "SalaryAccountHolder", 4000, true);
		Account savingAccount1 = new SavingAccount(101, "Parvati", 5000,false);
		
		SavingAccountService salaryAccountService = new SavingAccountService((SavingAccount) salAccount);
		salaryAccountService.chooseOperation();
		
		System.out.println("-------------------------------");
		
		SavingAccountService savingAccountService = new SavingAccountService((SavingAccount)savingAccount1);
		savingAccountService.chooseOperation();*/
		
		/*CurrentAccount currentAccount=new CurrentAccount(102, "SalaryAccountHolder", 4000);
		AccountService accountService=new AccountService(currentAccount);
		accountService.chooseAccount();*/
		/*SavingAccountsRepository savingRepo = new SavingAccountsRepository();
		System.out.println(savingRepo.getAllAccounts());*/
		/*System.out.println(savingRepo.getAccount(101));
		SavingAccount savingAccount = new SavingAccount(103, "Kajal", 10000, true);
		System.out.println(savingRepo.addAccount(savingAccount));
		System.out.println(savingRepo.getAllAccounts());
		System.out.println(savingRepo.removeAccount(102));
		System.out.println("After Deletion");
		System.out.println(savingRepo.getAllAccounts());*/
		
		/*CurrentAccountRepository currentAccountRepository=new CurrentAccountRepository();
		System.out.println(currentAccountRepository.getAllAccounts());*/
		
		AccountService accountService=new AccountService();
		accountService.chooseAccount();
	}

}
