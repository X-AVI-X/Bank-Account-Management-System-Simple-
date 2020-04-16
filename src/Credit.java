public class Credit extends Account{
    public double min=-100000;
    public final double limit=(balance)*.5;         //50% limit of withdrawal
    public int minAmount=20000;
    public double checkbalance;

    public Credit (String name,int day,int month,int year,String nominee,double balance) {
        super(name, day, month, year, nominee, balance);
    }
    public boolean deposit (double amount){
        checkbalance=amount+balance;
        if(amount>0)
        {
            balance=checkbalance;
            System.out.println("\nHello " + name+"!");
            System.out.println("BDT " + amount + " deposit successful!");
            System.out.println("Current balance is: " + balance);
            return true;
        }
        else{
            System.out.println("\nHello " + name);
        System.out.println("Deposit unsuccessful! Limit exceeds. Balance Unchanged.");
        System.out.println("Current balance is: "+balance);
        return false;
        }
    }
    public boolean withdraw(double amount)
    {
	checkbalance=balance-amount;
        if (amount>=limit && amount<=minAmount && min<=checkbalance) {
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
        System.out.println("\nCredit Account:");
        super.printAccount();
        return "Credit Account:" +
                "\nCURRENT INFORMATION:" +
                "\nDate of birth: "+DOB.day+"/"+DOB.month+"/"+DOB.year+
                "\nID: "+ID.ID() +
                "\nNAME: "+this.name +
                "\nCURRENT BALANCE: "+this.balance +
                "\nNOMINEE:"+this.nominee;
    }
}