import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {
	static String name;
	static int day;
	static int month;
	static int year;
	static String nominee;
	static double balance;
	static double amount;
	static int num = 0;

	private static int mainMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWelcome to Test Bank!");
		System.out.println("\nChoose your type of action from below: ");
		System.out.println("1. Create new account.");
		System.out.println("2. Log in to your account.");
		System.out.println("3. Exit");
		System.out.print("\nEnter option: ");
		int choiceOfMain = scan.nextInt();
		return choiceOfMain;
	}

	private static int createAcc() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nHello!");
		System.out.println("Which type of account you want to create today?");
		System.out.println("\n1. Debit Account");
		System.out.println("2. Credit Account");
		System.out.println("3. Savings Account");
		System.out.println("4. Go back to main menu.");
		System.out.println("5. Exit");
		System.out.print("\nEnter option: ");
		int choiceOfCreateAccount = scan.nextInt();
		return choiceOfCreateAccount;
	}

	private static void accountDetails() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter your full name: ");
		name = scan.nextLine();
		System.out.println("Enter your date of birth:");

		System.out.print("Year: ");
		year = scan.nextInt();
		System.out.print("Month: ");
		month = scan.nextInt();
		while (month > 12 || month < 1) {
			System.out.println("Invalid month. Please enter month again.");
			System.out.print("Month: ");
			month = scan.nextInt();
		}
		System.out.print("Day: ");
		day = scan.nextInt();
		while ((day < 1 || day > 31) || (year % 4 == 0 && month == 2 && day > 29) || (month == 2 && day > 28)) {
			System.out.println("Invalid Date. Please enter date again.");
			System.out.print("Day: ");
			day = scan.nextInt();
		}
		System.out.print("Nominee: ");
		scan.nextLine();
		nominee = scan.nextLine();
		System.out.print("Opening balance: ");
		balance = scan.nextDouble();
	}

	public static void main(String[] args) {
		int maxAccountNum = 10000;
		DebitAccount d[] = new DebitAccount[maxAccountNum];
		Credit c[] = new Credit[maxAccountNum];
		Savings s[] = new Savings[maxAccountNum];
		Scanner scan = new Scanner(System.in);
		boolean i = true;
		while (i) {
			switch (mainMenu()) {
				case 1: {
					switch (createAcc()) {
						case 1: {
							System.out.println("\nCreating Debit Account...\n" +
									"Please fill up your details below.");
							accountDetails();
							d[num] = new DebitAccount(name, day, month, year, nominee, balance);
							System.out.println("\nYour debit account is created successfully!");
							try {
								IDGENERATOR IDG = new IDGENERATOR(year, month);
								String ID = IDG.ID();
								String fileName = ID + ".txt";
								FileWriter debitFile = new FileWriter(fileName);
								debitFile.write(d[num].printAccount());
								debitFile.close();

								try {
									FileWriter myWriter = new FileWriter("num.txt");
									int numWriter = IDGENERATOR.number;
									myWriter.write(numWriter);
									myWriter.close();
								} catch (IOException e) {
									System.out.println("An error occurred storing ID number.");
									e.printStackTrace();
								}
							} catch (Exception e) {
								System.out.println("Error writing debit details.");
							}
							num++;
							break;
						}
						case 2: {
							System.out.println("\nCreating Credit Account...\n" +
									"Please fill up your details below.");
							accountDetails();
							c[num] = new Credit(name, day, month, year, nominee, balance);
							System.out.println("\nYour credit account is created successfully!");
							try {
								IDGENERATOR IDG = new IDGENERATOR(year, month);
								String ID = IDG.ID();
								String fileName = ID + ".txt";
								FileWriter creditFile = new FileWriter(fileName);
								//System.out.println("TEST BEFORE WRITING CREDIT DETAILS"+c[num].printAccount());
								creditFile.write(c[num].printAccount());
								creditFile.close();
								System.out.println("Your credit account details written to yout ID file permanently.");

								try {
									FileWriter numForCredit = new FileWriter("num.txt");
									int NumWriter = IDGENERATOR.number;
									numForCredit.write(NumWriter);
									numForCredit.close();
								} catch (IOException e) {
									System.out.println("An error occurred storing ID number.");
									e.printStackTrace();
								}
							} catch (Exception e) {
								System.out.println("Error writing credit details.");
							}
							num++;
							break;
						}
						case 3: {
							System.out.println("\nCreating savings Account...\n" +
									"Please fill up your details below.");
							accountDetails();
							s[num] = new Savings(name, day, month, year, nominee, balance);
							System.out.println("\nYour savings account is created successfully!");
							try {
								IDGENERATOR IDG = new IDGENERATOR(year, month);
								String ID = IDG.ID();
								System.out.println("Your ID is: " + ID);
								String fileName = ID + ".txt";
								FileWriter savingsFile = new FileWriter(fileName);
								savingsFile.write(s[(int) num].printAccount());
								savingsFile.close();

								try {
									FileWriter numForSavings = new FileWriter("num.txt");
									int NumWriter = IDGENERATOR.number;
									//System.out.println("This is forNumWriter: "numWriter);
									numForSavings.write(NumWriter);
									numForSavings.close();
								} catch (IOException e) {
									System.out.println("An error occurred storing ID number.");
									e.printStackTrace();
								}
							} catch (Exception e) {
								System.out.println("Error writing savings details.");
							}
							num++;
							break;
						}
						case 4: {
							continue;
						}
						case 5:
							i = false;
							break;
					}
					break;
				}
				case 2: {
					System.out.print("Enter ID in plain numbers: ");
					int inputID = scan.nextInt();
					System.out.print("Enter password: ");
					int inputPass = scan.nextInt();
					break;
				}
				case 3:
					i = false;
			}
		}
	}
}
