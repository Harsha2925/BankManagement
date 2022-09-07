package banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankManagement {
	static Connection con = connection.getConnection();
	public static void AccountOpen(String name,int balance) throws ClassNotFoundException, SQLException {
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT MAX(Cid) FROM Customer");
			int max=0;
			while(result.next()) {
				max = result.getInt("MAX(Cid)");
			}
			max+=1;
			String query="Insert INTO Customer(Cid,Cname,Balance) VALUES("+max +",'"+name+"',"+ balance +")";
			int ct = stmt.executeUpdate(query);
			if(ct>0) {
				System.out.println("Your Account created successfully! your customer id is : "+ max);
			} else {
				System.out.println("There is some error while creating your account,contact support team!!!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void checkBalance(int id) throws ClassNotFoundException, SQLException {
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT Cname,balance FROM Customer" + " where Cid= "+id+"");
			int balanceamt=0;
			String name="";
			while (rset.next()) {
				name=rset.getString("Cname");
			    balanceamt=rset.getInt("balance");
			}
				System.out.println("Customer name : " +name+ " With Customer id : "+ id + " has a current balance : Rs."+balanceamt);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void withdrawal(int id,int amount) throws ClassNotFoundException, SQLException {
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT balance FROM Customer" + " where Cid= "+id+"");
			int balanceamt=0;
			while (rset.next())
			    balanceamt=rset.getInt(1);
			if(balanceamt<amount) {
				System.out.println("You Don't have sufficient balance");
			}else {
					balanceamt-=amount;
					@SuppressWarnings("unused")
					ResultSet rs = stmt.executeQuery("UPDATE Customer " + "SET balance="+balanceamt+" where Cid="+id+"");
					ResultSet rsett = stmt.executeQuery("SELECT Cname ,balance FROM Customer" + " where Cid= "+id+"");
					int updatedamtt=0;
					String name="";
					while(rsett.next()) {
					name=rsett.getString("Cname");
			        updatedamtt = rsett.getInt("balance");
					}
					System.out.println("Customer name : " +name+ " With Customer id : "+ id + " withdrawal amount Rs."+amount+" has a current balance : Rs."+updatedamtt);
				}
			} catch(Exception e) {
				e.printStackTrace();
		}
	}		
	public static void deposit(int id,int amount) throws SQLException, ClassNotFoundException {
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT balance FROM Customer" + " where Cid= "+id+"");
			int balanceamt=0;
			while (rset.next())
			    balanceamt=rset.getInt(1);
			balanceamt+=amount;
			@SuppressWarnings("unused")
			ResultSet rs = stmt.executeQuery("UPDATE Customer " + "SET balance="+balanceamt+" where Cid="+id+"");
			ResultSet rsett = stmt.executeQuery("SELECT Cname,balance FROM Customer" + " where Cid="+id+"");
			int updatedamtt=0;
			String name="";
			while(rsett.next()) {
				name=rsett.getString("Cname");
				updatedamtt = rsett.getInt("balance");
			}
			System.out.println("Customer name : " +name+ " With Customer id : "+ id + " Deposited amount Rs."+amount+" has a current balance : Rs."+updatedamtt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}