package banking;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		@SuppressWarnings("resource")
		Scanner scn=new Scanner(System.in);
		while(true) {
			System.out.println("--------------------Menu------------------");
			System.out.println("Hello customer, Choose what you want to do");
			System.out.println("1. Opening an account in our bank");
			System.out.println("2. Check Balance of your account");
			System.out.println("3. Withdrawal amount from your account");
			System.out.println("4. Deposit amount in your account");
			System.out.println("5. Exit from your login");
			System.out.println("Enter your option : ");
			int option=scn.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter you name :");
					String name=scn.next();
					System.out.println("Enter the initial amount you want to deposit in your account:");
					int balance=scn.nextInt();	
					BankManagement.AccountOpen(name,balance);
					break;
				case 2:
					System.out.println("Enter you customer ID:");
					int id1=scn.nextInt();
					BankManagement.checkBalance(id1);
					break;
				case 3:
					System.out.println("Enter you customer ID:");
					int id2=scn.nextInt();
					System.out.println("Enter amount you want to withdrawal from your account:");
					int amount=scn.nextInt();
					BankManagement.withdrawal(id2,amount);
					break;
				case 4:
					System.out.println("Enter you cust ID:");
					int id3=scn.nextInt();
					System.out.println("Enter amount you want to deposit in your account:");
					int amount1=scn.nextInt();
					BankManagement.deposit(id3,amount1);
					break;
				case 5:
					System.out.println("Exit successfully,Have a nice day!!! Hope you like our bank services.");
					return;
				default:
					System.out.println("Sorry!!, please enter the correct input and try again");
					break;
			}
		}
	}
}
