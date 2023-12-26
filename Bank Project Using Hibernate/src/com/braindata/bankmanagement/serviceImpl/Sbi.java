package com.braindata.bankmanagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.braindata.bankmanagement.config.HibernateUtil;
import com.braindata.bankmanagement.model.Account;
import com.braindata.bankmanagement.model.Bank;
import com.braindata.bankmanagement.service.Rbi;

public class Sbi implements Rbi {
	static Scanner sc = new Scanner(System.in);

	@Override
	public void createAccount() {
		Session ss = HibernateUtil.getSessionFactory().openSession();
		Bank b = new Bank(); // ONE TO MANY (ONE BANK ---> MANY ACCOUNT)
		System.out.println("Bank Database\n");
		System.out.println("Enter Bank Code");
		b.setBank_code(sc.nextInt());
		System.out.println("Enter Bank Address");
		b.setBank_Address(sc.next());

		System.out.println("Account Database- Object 1\n");
		Account a = new Account();
		System.out.println("Enter Account Number");
		a.setAccNo(sc.nextInt());
		System.out.println(" Enter Account Name");
		a.setName(sc.next());
		System.out.println("Enter Account Amount");
		a.setAccount_Amount(sc.nextFloat());
		
		System.out.println("Account Database- Object 2\n");
		Account a2 = new Account();
		System.out.println("Enter Account Number");
		a2.setAccNo(sc.nextInt());
		System.out.println(" Enter Account Name");
		a2.setName(sc.next());
		System.out.println("Enter Account Amount");
		a2.setAccount_Amount(sc.nextFloat());

		b.getAccn().add(a);
		b.getAccn().add(a2);
		ss.save(b);
		ss.beginTransaction().commit();
	}

	@Override
	public void displayAllDetails() {

		Session ss = HibernateUtil.getSessionFactory().openSession();
		// Query<Bank>q =ss.createNamedQuery("Showall");=
		Query<Bank> b = ss.getNamedQuery("Showall");
		// Query<Account> a=ss.getNamedQuery("Showall");

		List<Bank> b1 = b.getResultList();
		// List<Account> aa=a.getResultList();
		for (Bank b2 : b1) {
			for (Account a2 : b2.getAccn()) {
				System.out.println("Bank Details\n");
				System.out.println("Bank Code :- " + b2.getBank_code());
				System.out.println("Bank Address:- " + b2.getBank_Address());
				System.out.println("Account Details\n");
				System.out.println("Account number:- " + a2.getAccNo());
				System.out.println("Account Name:- " + a2.getName());
				System.out.println("Account Salary:-"+a2.getAccount_Amount());
			}
		}
	}

	@Override
	public void depositeMoney() 
	{
		Session ss = HibernateUtil.getSessionFactory().openSession();	
        System.out.println("Enter Account Number You want to Deposit Amount");
        int n = sc.nextInt();

        System.out.println("Enter Amount you Want to Deposit");
        int damount = sc.nextInt();

        Query<Account> query = ss.createNamedQuery("Deposit Amount");
        query.setParameter("accNo", n);
        Account a3  = query.getSingleResult();
        float d= a3.getAccount_Amount()+damount;
		a3.setAccount_Amount(d);
		
		ss.update(a3);
		ss.beginTransaction().commit();
		
		
////		System.out.println("Enter Account Number You want to Deposit Amount");
////		int w= sc.nextInt();
//		Query<Bank> q1=ss.createNamedQuery("Deposit Amount");
//		 q1.setParameter("accNo", );
//	        Bank bank = query.uniqueResult();
//		System.out.println("Enter Amount you Want to Deposit");
//		int w1= sc.nextInt();
//		Query<Bank> q3=q1.getSingleResult()+w1;
        }

	@Override
	public void withdrawal()
	{
		
		Session ss = HibernateUtil.getSessionFactory().openSession();	
        System.out.println("Enter Account Number You want to Withdraw Amount");
        int n = sc.nextInt();

        System.out.println("Enter Amount you Want to Withdraw");
        int damount = sc.nextInt();

        Query<Account> query = ss.createNamedQuery("Withdraw");
        query.setParameter("accNo", n);
        Account a3  = query.getSingleResult();
        float d= a3.getAccount_Amount()-damount;
		a3.setAccount_Amount(d);
		
		ss.update(a3);
		ss.beginTransaction().commit();
	}

	@Override
	public void balanceCheck()
	{
		Session ss = HibernateUtil.getSessionFactory().openSession();	
		System.out.println("Enter Account Number You want to Check Balance");
		int c1= sc.nextInt();
		Query<Account> query = ss.createNamedQuery("Balance Check");
		query.setParameter("accNo",c1);
		Float a5=query.uniqueResult().getAccount_Amount();
		System.out.println(" Balance Check:-"+a5);
		
		
		
	}

}
