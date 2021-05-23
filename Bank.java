import java.util.Scanner;

class Account {
	String acno;
	String name;
	float bal;

	/* constructor */
	public Account(String acno, String name, float bal) {
		this.acno = acno;
		this.name = name;
		this.bal = bal;
		System.out.println("A/C Created!!");
	}

	void deposit(float amt) {
		this.bal = this.bal + amt;
		System.out.println("Rs." + amt + " Deposited || Balance: " + this.bal);
	}

	void withdraw(float amt) {
		if (this.bal >= amt) {
			this.bal -= amt;
			System.out.println("Rs." + amt + " Debited || Balance: " + this.bal);
		} else {
			System.out.println("FYI: Insufficient Balance");
		}
	}

	void getBalance() {
		System.out.println("Name: " + this.name + " | A/C No: " + this.acno + " | Balance: " + this.bal);
	}
}

public class Bank {
	public static void main(String[] args) {
		Account acc = null;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Create A/C");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.Balance");
			System.out.println("5.Exit");

			System.out.print("enter an option: ");
			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				if (acc == null) {
					System.out.print("enter A/C No: ");
					String acno = sc.next();
					sc.nextLine();
					System.out.print("enter name: ");
					String name = sc.nextLine();
					System.out.print("enter initial amount: ");
					float amt = sc.nextFloat();
					/* create Account object */
					acc = new Account(acno, name, amt);
				} else {
					System.out.println("FYI: A/C is already created!");
				}
				break;
			case 2:
				if (acc != null) {
					System.out.print("enter amount to deposit: ");
					float amt = sc.nextFloat();
					acc.deposit(amt);
				} else {
					System.out.println("FYI: Create A/C first");
				}
				break;
			case 3:
				if (acc != null) {
					System.out.print("enter amount to withdraw: ");
					float amt = sc.nextFloat();
					acc.withdraw(amt);
				} else {
					System.out.println("FYI: Create A/C first");
				}
				break;
			case 4:
				if (acc != null) {
					acc.getBalance();	
				} else {
					System.out.println("FYI: Create A/C first");
				}
				break;
			default:
				System.out.println("** BYE BYE **");
				System.exit(0); // to terminate the program
				sc.close();
				break;
			}
			System.out.println("====================================");
		}

	}
}
