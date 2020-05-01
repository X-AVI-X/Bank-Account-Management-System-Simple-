import java.util.Scanner;

public class Credit extends Account{
    public double min=-100000;
    public final double limit=(balance)*.5;         //50% limit of withdrawal
    public int minAmount=20000;
    public double checkBalance;

    public Credit (String name,int day,int month,int year,String nominee,double balance) {
        super(name, day, month, year, nominee, balance);
    }
    public void deposit (){
        System.out.println("\nYou chose to deposit money...");
        Scanner scan = new Scanner(System.in);
        double amount;
        System.out.print("Enter amount: ");
        amount = scan.nextDouble();
        checkBalance =amount+balance;
        if(amount>0)
        {
            balance= checkBalance;
            System.out.println("\nHello " + name+"!");
            System.out.println("BDT " + amount + " deposit successful!");
        }
        else{
            System.out.println("\nHello " + name+".");
            System.out.println("Deposit unsuccessful! Limit exceeds. Balance Unchanged.");
        }
        System.out.println("Current balance is: " + balance);
    }

    public void withdraw() {
        System.out.println("\nYou chose to withdraw money...");
        Scanner scan = new Scanner(System.in);
        double amount;
        System.out.print("Enter amount: ");
        amount = scan.nextDouble();
	    checkBalance =balance-amount;
        if (amount>=limit && amount<=minAmount && min<= checkBalance) {
            balance = balance - amount;
            System.out.println("\nHello " + name+"!");
            System.out.println("BDT "+amount+" Withdrawal Successful!");
            System.out.println("Current balance is: "+balance);
        }
        else {
            System.out.println("\nHello " + name+"!");
            System.out.println("BDT "+amount+" Withdrawal unsuccessful!");
            System.out.println("Current balance is: "+balance);
        }
    }
    public String printAccount()
    {
        return "Credit Account:" +
                "\nCURRENT INFORMATION:" +
                "\nDate of birth: "+DOB.day+"/"+DOB.month+"/"+DOB.year+
                "\nID: "+ID.ID() +
                "\nNAME: "+this.name +
                "\nCURRENT BALANCE: "+this.balance +
                "\nNOMINEE:"+this.nominee;
    }
    public String loggedPrintAccount(String accNum)
    {
        return "Credit Account:" +
            "\nCURRENT INFORMATION:" +
            "\nDate of birth: "+DOB.day+"/"+DOB.month+"/"+DOB.year+
            "\nID: "+accNum+
            "\nNAME: "+this.name +
            "\nCURRENT BALANCE: "+this.balance +
            "\nNOMINEE:"+this.nominee;
    }
}