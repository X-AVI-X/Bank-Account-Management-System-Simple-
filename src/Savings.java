import java.util.Scanner;

public class Savings extends Account{

    public Savings (String name,int day,int month,int year,String nominee,double balance) {
        super(name, day, month, year, nominee, balance);
    }
    public void deposit() {
        System.out.println("\nYou chose to deposit money...");
        Scanner scan = new Scanner(System.in);
        double amount;
        System.out.print("Enter amount: ");
        amount = scan.nextDouble();
        if (amount>0){
            balance+=amount;
            System.out.println("\n BDT "+amount+" Deposit successful!");
        }
    }

    public void withdraw() {
        System.out.println("\nYou chose to withdraw money...");
        Scanner scan = new Scanner(System.in);
        double amount;
        System.out.print("Enter amount: ");
        amount = scan.nextDouble();
        if (amount<=balance)
        {
            balance = balance - amount;
            System.out.println("\n BDT "+amount+" Withdrawal Successful!");
        }
    }

    public String printAccount() {
        return "Savings Account:\n" +
                "\nCURRENT INFORMATION:" +
                "\nDate of birth: "+DOB.day+"/"+DOB.month+"/"+DOB.year+
                "\nID: "+ID.ID() +
                "\nNAME: "+this.name+
                "\nCURRENT BALANCE: "+this.balance+
                "\nNOMINEE: \"+this.nominee";
    }

    public String loggedPrintAccount(String accNum) {
        return "Savings Account:" +
                "\nCURRENT INFORMATION:" +
                "\nDate of birth: "+DOB.day+"/"+DOB.month+"/"+DOB.year+
                "\nID: "+accNum+
                "\nNAME: "+this.name +
                "\nCURRENT BALANCE: "+this.balance +
                "\nNOMINEE:"+this.nominee;
    }
}