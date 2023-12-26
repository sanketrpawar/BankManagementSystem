package com.braindata.bankmanagement.client;

import java.util.Scanner;

import com.braindata.bankmanagement.model.Bank;
import com.braindata.bankmanagement.serviceImpl.Sbi;

public class Test 
{

	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Bank Management System Using Hibernate\n");
		System.out.println("1.Create Account");
		System.out.println("2.Display All Details");
		System.out.println("3.Deposite Money");
		System.out.println("4.Withdrawal");
		System.out.println("5.Balance Check");
		System.out.println("Enter Choice");
		int choice=sc.nextInt();
		Sbi s= new Sbi();
		
		
		switch(choice)
		{
		case 1: 
			s.createAccount();
			break;
		case 2:
			s.displayAllDetails();
			break;
		case 3:
			s.depositeMoney();
			break;
		case 4:
			s.withdrawal();
			break;
		case 5:
			s.balanceCheck();
			break;
			
		}
	}

}
