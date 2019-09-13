package com.bv.model;

public class SalaryAccount extends Account {

	private boolean creditCardIssued;

	public SalaryAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalaryAccount(int acc_no, String holder_name, double balance, boolean creditCardIssued) {
		super(acc_no, holder_name, balance);
		this.creditCardIssued = creditCardIssued;

	}

	public boolean isCreditCardIssued() {
		return creditCardIssued;
	}

	public void setCreditCardIssued(boolean creditCardIssued) {
		this.creditCardIssued = creditCardIssued;
	}

	

}
