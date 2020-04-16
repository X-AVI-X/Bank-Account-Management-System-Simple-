public class Account
{	
	protected IDGENERATOR ID;
	protected static Date DOB;
	protected String name;
	protected String nominee;
	protected double balance ;

	public Account()
	{
	}
	public Account(String name,int day,int month,int year,String nominee,double balance)// parameterized constructor
	{
		this.DOB = new Date(day, month, year);
		this.ID = new IDGENERATOR(year, month);
		this.name = name;
		this.nominee = nominee;
		this.balance = balance;
	}
	public String printAccount()
	{
		System.out.println("__CURRENT INFORMATIONS__");
		System.out.println("Date: "+DOB.day+"/"+DOB.month+"/"+DOB.year);
		System.out.println("ID: "+ID.ID());
		System.out.println("NAME: "+this.name);
		System.out.println("CURRENT BALANCE: "+this.balance);
		System.out.println("NOMINEE: "+this.nominee);
		System.out.println();
		return "";
	}

	public boolean withdraw(double amount)
	{
		if(amount<=balance)
		{
			balance-=amount;
			return true;
		}
		else
			return false;
	}
	public boolean deposit(double amount)
	{
		if (amount>0){
			balance+=amount;
			return true;
		}
		else return false;
	}
	
}	

