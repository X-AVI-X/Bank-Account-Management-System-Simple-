public class DebitAccount extends Account{
	public double max=100000;
	public int maxAmount=20000;
	public double checkBalance;

	public DebitAccount (String name,int day,int month,int year,String nominee,double balance) {
		super(name, day, month, year, nominee, balance);
	}
	public boolean deposit (double amount) {
		checkBalance = amount + balance;
		if (amount > 0 && amount <= maxAmount && checkBalance <= max) {
			balance = checkBalance;
			System.out.println("\nHello " + name+"!");
			System.out.println("BDT " + amount + " deposit successful!");
			System.out.println("Current balance is: " + balance);
			return true;
		} else {
			System.out.println("\nHello " + name);
			System.out.println("Deposit unsuccessful! Limit exceeds. Balance Unchanged.");
			System.out.println("Current balance is: "+balance);
			return false;
		}
	}
	public boolean withdraw(double amount)
	{
		if (amount<=balance)
		{
			balance = balance - amount;
			System.out.println("\nHello " + name+"!");
			System.out.println("BDT "+amount+" Withdrawal Successful!");
			System.out.println("Current balance is: "+balance);
			return true;
		}
		else {
			System.out.println("\nHello " + name+"!");
			System.out.println("BDT "+amount+" Withdrawal unsuccessful!");
			System.out.println("Current balance is: "+balance);
			return false;
		}
	}
	public String printAccount()
	{
		System.out.println("\nDebit Account:");
		super.printAccount();
		return "Debit Account:"+
			   "\nCURRENT INFORMATION:" +
			   "\nDate of birth: "+DOB.day+"/"+DOB.month+"/"+DOB.year+
			   "\nID: "+ID.ID()+
			   "\nNAME: "+this.name+
			   "\nCURRENT BALANCE: "+this.balance+
			   "\nNOMINEE: "+this.nominee;
	}
}