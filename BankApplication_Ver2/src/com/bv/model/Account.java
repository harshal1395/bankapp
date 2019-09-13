package com.bv.model;

public class Account {
	private int acc_no;
	private String holder_name;
	private double balance;
	private String acc_type;
	public Account() {
		// TODO Auto-generated constructor stub
		
	}
static
{
	System.out.println("*********************************************************");
	System.out.println("-----------------Welcome To Bank of CDAC-----------------");
	System.out.println("--------------------Branch : VITA------------------------");
	System.out.println("-----------------------Juhu------------------------------");
	System.out.println("*********************************************************\n");
}
	public Account(int acc_no, String holder_name, double balance) {
		super();
		
		this.acc_no = acc_no;
		this.holder_name = holder_name;
		this.balance = balance;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getHolder_name() {
		return holder_name;
	}

	public void setHolder_name(String holder_name) {
		this.holder_name = holder_name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account Number= " + acc_no + "\n"+"Account Holder Name=" + holder_name + "\n"+ "Account Balance=" + balance +
				"\n"+"Account Type = "+ acc_type + "\n";
	}
				

	
}
