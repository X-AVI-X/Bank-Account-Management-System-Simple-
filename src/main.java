import java.io.*;
import java.util.Scanner;

public class main {
	static String name;
	static int day;
	static int month;
	static int year;
	static String nominee;
	static double balance;
	static int num = 0;

	private static int mainMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWelcome to Test Bank!");
		System.out.println("\nChoose your type of action from below: ");
		System.out.println("1. Create new account.");
		System.out.println("2. Log in to your account. [You can see your account info, deposit or withdraw your money from here.]");
		System.out.println("3. Exit");
		System.out.print("\nEnter option: ");
		try {
			int choiceOfMain = scan.nextInt();
			return choiceOfMain;
		}
		catch (Exception e){
			return 4;						//It will execute the default command of switch(mainMenu)
		}
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
		try {
			int choiceOfCreateAcc= scan.nextInt();
			return choiceOfCreateAcc;
		}
		catch (Exception e){
			return 6;						//It will execute the default command of switch(createAcc)
		}
	}

	private static void accountDetails() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter your full name: ");
		name = scan.nextLine();
		System.out.println("Enter your date of birth:");

		System.out.print("Year: ");
		year=scan.nextInt();
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

	public static int pinGenerator(){
		int pin;
		pin=IDGENERATOR.num()*year/980+month*314+day+623+IDGENERATOR.num()*year/day/month;
		return pin;
	}

	public static int pinGenerator(int numTxt){
		int pin;
		pin=numTxt*year/980+month*314+day+623+numTxt*year/day/month;
		return pin;
	}

	public static void main(String[] args) {
		int maxAccountNum = 10000;
		DebitAccount[] d = new DebitAccount[maxAccountNum];
		Credit[] c = new Credit[maxAccountNum];
		Savings[] s = new Savings[maxAccountNum];
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
								///////////////////////////////////////////////////////////////////////////////////////////////
								IDGENERATOR IDG = new IDGENERATOR(year, month);
								String ID = IDG.ID();
								String fileName = ID + ".txt";
								String path = "D:\\Study\\JavaCodes\\Account\\";
								path = path + ID;
								//Creating a File object
								File file = new File(path);
								//Creating the directory
								boolean bool = file.mkdir();
								if (bool) {
									System.out.println("Directory created successfully");
								} else {
									System.out.println("Sorry couldn’t create specified directory");
								}////////////////////////////////////////////////////////////////////////////////////////////
								FileWriter debitFile = new FileWriter(path + File.separator + fileName);
								debitFile.write(IDGENERATOR.num() - 1 + "\t" + name + "\t" + year + "\t" + month + "\t"
										+ day + "\t" + nominee + "\t" + balance
										+ "\t" + "Debit");
								System.out.println("Your account number is: " + ID);
								System.out.println("Your pin is: " + pinGenerator());
								System.out.println("Remember this for future login to your account.");
								debitFile.close();
								System.out.println("Your debit account details has been written to your ID file permanently.");

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
								///////////////////////////////////////////////////////////////////////////////////////////////
								IDGENERATOR IDG = new IDGENERATOR(year, month);
								String ID = IDG.ID();
								String fileName = ID + ".txt";
								String path = "D:\\Study\\JavaCodes\\Account\\";
								path = path + ID;
								//Creating a File object
								File file = new File(path);
								//Creating the directory
								boolean bool = file.mkdir();
								if (bool) {
									System.out.println("Directory created successfully");
								} else {
									System.out.println("Sorry couldn’t create specified directory");
								}////////////////////////////////////////////////////////////////////////////////////////////
								FileWriter creditFile = new FileWriter(path + File.separator + fileName);
								creditFile.write(IDGENERATOR.num() - 1 + "\t" + name + "\t" + year + "\t" + month + "\t"
										+ day + "\t" + nominee + "\t" + balance
										+ "\t" + "Credit");
								System.out.println("Your account number is: " + ID);
								System.out.println("Your pin is: " + pinGenerator());
								System.out.println("Remember this for future login to your account.");
								creditFile.close();
								System.out.println("Your credit account details has been written to your ID file permanently.");

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
								///////////////////////////////////////////////////////////////////////////////////////////////
								IDGENERATOR IDG = new IDGENERATOR(year, month);
								String ID = IDG.ID();
								String fileName = ID + ".txt";
								String path = "D:\\Study\\JavaCodes\\Account\\";
								path = path + ID;
								//Creating a File object
								File file = new File(path);
								//Creating the directory
								boolean bool = file.mkdir();
								if (bool) {
									System.out.println("Directory created successfully");
								} else {
									System.out.println("Sorry couldn’t create specified directory");
								}////////////////////////////////////////////////////////////////////////////////////////////
								FileWriter savingsFile = new FileWriter(path + File.separator + fileName);
								savingsFile.write(IDGENERATOR.num() - 1 + "\t" + name + "\t" + year + "\t" + month + "\t"
										+ day + "\t" + nominee + "\t" + balance
										+ "\t" + "Savings");
								System.out.println("Your account number is: " + ID);
								System.out.println("Your pin is: " + pinGenerator());
								System.out.println("Remember this for future login to your account.");
								savingsFile.close();
								System.out.println("Your savings account details has been written to your" +
										" ID file permanently.");

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
						case 5: {
							i = false;
							break;
						}
						default: System.out.println("Invalid option. Write valid option (eg: 2).");
					}
					break;
				}
				//-----------------------------------------------------------------//
				//                   LOGIN SYSTEM STARTS HERE			           //
				//-----------------------------------------------------------------//
				case 2: {
					System.out.print("Enter your account number: ");
					String inputID = scan.next().trim();
					//inputID= inputID.trim();
					String idFile = inputID + ".txt";
					String idFolder = "D:\\Study\\JavaCodes\\Account\\" + File.separator + inputID;
					try {
						int numTxt = 0;
						String accType = null;
						BufferedReader br = new BufferedReader(new FileReader(
								idFolder + File.separator + idFile));
						String line;
						while ((line = br.readLine()) != null) {
							String[] temp = line.split("\t");
							numTxt = Integer.parseInt(temp[0]);
							name = temp[1];
							year = Integer.parseInt(temp[2]);
							month = Integer.parseInt(temp[3]);
							day = Integer.parseInt(temp[4]);
							nominee = temp[5];
							balance = Double.parseDouble(temp[6]);
							accType = temp[7];
						}
						System.out.print("Enter pin: ");
						int inputPin = scan.nextInt();
						if (inputPin == pinGenerator(numTxt + 1)) {
							System.out.println();
							System.out.println("***********************");
							System.out.println("** Login successful! **");
							System.out.println("***********************");
							assert accType != null;
							switch (accType) {
								case "Debit": {
									d[num] = new DebitAccount(name, day, month, year, nominee, balance);
									System.out.println(d[num].loggedPrintAccount(inputID));
									System.out.println("***********************");
									switch (afterLoginAction()) {
										case 1: {
											d[num].deposit();
											accUpdater(idFolder + File.separator + idFile, numTxt, accType, d[num].balance);
											break;
										}
										case 2: {
											d[num].withdraw();
											accUpdater(idFolder + File.separator + idFile, numTxt, accType, d[num].balance);
										}
										case 3: {
											break;
										}
										case 4: {
											System.out.println("Closing application...");
											i = false;
											break;
										}
										default:
											System.out.println("Invalid choice.");
									}
								}
								break;
								case "Credit": {
									c[num] = new Credit(name, day, month, year, nominee, balance);
									System.out.println(c[num].loggedPrintAccount(inputID));
									switch (afterLoginAction()) {
										case 1: {
											c[num].deposit();
											accUpdater(idFolder + File.separator + idFile, numTxt, accType, c[num].balance);
											break;
										}
										case 2: {
											c[num].withdraw();
											accUpdater(idFolder + File.separator + idFile, numTxt, accType, c[num].balance);
											break;
										}
										case 3: {
											break;
										}
										case 4: {
											System.out.println("Closing application...");
											i = false;
											break;
										}
										default: System.out.println("Invalid option. Write valid option (eg: 2).");
										break;
									}
								}
								break;
								case "Savings": {
									s[num] = new Savings(name, day, month, year, nominee, balance);
									System.out.println(s[num].loggedPrintAccount(inputID));
									switch (afterLoginAction()) {
										case 1: {
											s[num].deposit();
											accUpdater(idFolder + File.separator + idFile, numTxt, accType, s[num].balance);
											break;
										}
										case 2: {
											s[num].withdraw();
											accUpdater(idFolder + File.separator + idFile, numTxt, accType, s[num].balance);
											break;
										}
										case 3: {
											break;
										}
										case 4: {
											System.out.println("Closing application...");
											i = false;
											break;
										}
										default: System.out.println("Invalid option. Write valid option (eg: 2).");
										break;
									}
								}
								break;
								default:
									System.out.println("Data not found.");
									break;
							}
						} else System.out.println("Login unsuccessful.");
					} catch (IOException e) {
						System.out.println("Your account number is wrong/doesn't exist.");
					}
					break;
				}
				case 3: {
					i = false;
					break;
				}
				default: System.out.println("Invalid option. Write valid option (eg: 2).");
			}
		}
	}

	private static void accUpdater(String idFile, int numText, String accType, double balance){
		try {
			FileReader read = new FileReader(idFile);
			Scanner scan = new Scanner(read);
			String tempData=scan.nextLine();
			while (scan.hasNextLine()){
				tempData=tempData + "\n" + scan.nextLine();
			}
			read.close();
			FileWriter File = new FileWriter(idFile);
			File.write(tempData+"\n"
					+numText + "\t" + name + "\t" + year + "\t" + month + "\t" + day + "\t" + nominee + "\t" + balance
					+ "\t" + accType);
			File.close();
		} catch (IOException e){
			System.out.println("Error writing updated details.");
		}
	}

	private static int afterLoginAction(){
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWhat do you want to do now?");
		System.out.println("1. Deposit money.");
		System.out.println("2. Withdraw money.");
		System.out.println("3. Go back to main menu.");
		System.out.println("4. Exit.");
		System.out.print("\nEnter choice: ");
		try {
			int choiceOfAfterLogin = scan.nextInt();
			return choiceOfAfterLogin;
		}
		catch (Exception e){
			return 5;						//It will execute the default command of switch
		}
	}
}