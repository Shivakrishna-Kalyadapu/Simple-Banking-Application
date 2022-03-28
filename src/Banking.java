import java.util.Scanner;

public class Banking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account obj1 = new Account("ABCDE", "ABC1234");
		obj1.showMenu();
	}

}

class Account {
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;

	Account(String cname, String cid)
	{
		customerName = cname;
		customerId = cid;
	}

	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}

	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}

	void getPreviousTransaction()
	{
		if (previousTransaction > 0)
		{
			System.out.println("Deposited amount is : " + previousTransaction);
		}
		else if (previousTransaction < 0)
		{
			System.out.println("Withdrawn amount is : " + Math.abs(previousTransaction));
		}
		else
		{
			System.out.println("No transaction occured");
		}
	}

	void showMenu()
	{
		char option = '\0';
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Welcome " + customerName);
		System.out.println("Your ID is : " + customerId);
		System.out.println("\n");
		
		
		do
		{
			System.out.println("A - Check Balance");
			System.out.println("B - Deposit");
			System.out.println("C - Withdraw");
			System.out.println("D - Previous transaction");
			System.out.println("E - Exit");
			System.out.println("=================================");
			System.out.println("Enter an option");
			System.out.println("=================================");
			option = sc.next().charAt(0);
			System.out.println("\n");
			
			switch (option)
			{
			case 'A' :
				System.out.println("----------------------------");
				System.out.println("Balance = " + balance);
				System.out.println("----------------------------");
				System.out.println("\n");
				break;
				
			case 'B' :
				System.out.println("----------------------------");
				System.out.println("Enter an amount to deposit : ");
				System.out.println("----------------------------");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println(amount + "/- is deposited");
				System.out.println("\n");
				break;
				
			case 'C' :
				System.out.println("----------------------------");
				System.out.println("Enter an amount to withdraw : ");
				System.out.println("----------------------------");
				int amount2 = sc.nextInt();
				withdraw(amount2);
				System.out.println(amount2 + "/- is withdrawn");
				System.out.println("\n");
				break;
				
			case 'D' :
				System.out.println("----------------------------");
				getPreviousTransaction();
				System.out.println("----------------------------");
				System.out.println("\n");
				break;
				
			case 'E' :
				System.out.println("****************************");
				break;
				
				default :
					System.out.println("Invalid Option!, Please enter a valid option");
					break;
			}
		}
			while (option != 'E');
			
		System.out.println("Thank You for using our Bank services");
	}
	
}