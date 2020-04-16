public class Savings extends Account{

    public Savings (String name,int day,int month,int year,String nominee,double balance) {
        super(name, day, month, year, nominee, balance);
    }
    public boolean deposit(double amount)
    {
        if (amount>0){
            balance+=amount;
            System.out.println("\n BDT "+amount+" Deposit successful!");
            return true;
        }
        else return false;
    }
    public boolean withdraw(double amount)
    {
        if (amount<=balance)
        {
            balance = balance - amount;
            System.out.println("\n BDT "+amount+" Withdrawal Successful!");
            return true;
        }
        else return false;
    }
    public String printAccount()
    {
        System.out.println("\nSavings Account:");
        super.printAccount();
        return "Savings Account:\n" +
                "\nCURRENT INFORMATION:" +
                "\nDate of birth: "+DOB.day+"/"+DOB.month+"/"+DOB.year+
                "\nID: "+ID.ID() +
                "\nNAME: "+this.name+
                "\nCURRENT BALANCE: "+this.balance+
                "\nNOMINEE: \"+this.nominee";
    }
}