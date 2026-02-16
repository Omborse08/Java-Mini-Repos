package BankAccount;

import java.util.Scanner;

public class FrontEnd_Cli {
    static void showMenu() {
        System.out.println("\n1. Create Account\n" +
                "2. Deposit Money\n" +
                "3. Transfer Money\n" +
                "4. View Account\n" +
                "5. Exit");
    }

    static void showAccountType() {
        System.out.println("\n1. Savings Account\n" +
                "2. Current Account\n" +
                "3. Premium Account");
    }

    static void showModes() {
        System.out.println("1. UPI\n" +
                "2. Credit Card\n" +
                "3. Net Banking");
    }

    static void main(String... args) {
        int Savingcount = 101;
        int Currentcount = 201;
        int Premiumcount = 301;
        BankManager bankManager = new BankManager();
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        showMenu();
        while (isRun) {
            System.out.print("Choose Option: ");
            int choose = sc.nextInt();
            Account user;
            switch (choose) {
                case 1:
                    System.out.println("Select Account Type:");
                    showAccountType();
                    System.out.print("\nChoose Option: ");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            sc.nextLine();
                            System.out.print("Enter Account Holders Name: ");
                            String name = sc.nextLine();
                            System.out.print("Initial Deposite: ");
                            int initialDeposite = sc.nextInt();
                            user = new SavingAccount(name,Savingcount,initialDeposite);
                            if (bankManager.addHolder(user)) {
                                System.out.println("Account Added Successfully!");
                                System.out.println("Account Type: "+user.accountType());
                                System.out.println("Account Number: "+Savingcount++);
                                System.out.println("Account Balance: "+initialDeposite);

                            }
                            else {
                                System.out.println("Something Is Wrong Try Again!");
                            }
                            break;

                        case 2:
                            sc.nextLine();
                            System.out.print("Enter Account Holders Name: ");
                            String name1 = sc.nextLine();
                            System.out.print("Initial Deposite: ");
                            int initialDeposite1 = sc.nextInt();
                            user = new CurrentAccount(name1,Currentcount,initialDeposite1);
                            if (bankManager.addHolder(user)) {
                                System.out.println("Account Added Successfully!");
                                System.out.println("Account Type: "+user.accountType());
                                System.out.println("Account Number: "+Currentcount++);
                                System.out.println("Account Balance: "+initialDeposite1);
                            }
                            else {
                                System.out.println("Something Is Wrong Try Again!");
                            }
                            break;

                        case 3:
                            sc.nextLine();
                            System.out.print("Enter Account Holders Name: ");
                            String name2 = sc.nextLine();
                            System.out.print("Initial Deposite: ");
                            int initialDeposite2 = sc.nextInt();
                            user = new PremiumAccount(name2,Premiumcount,initialDeposite2);
                            if (bankManager.addHolder(user)) {
                                System.out.println("Account Added Successfully!");
                                System.out.println("Account Type: "+user.accountType());
                                System.out.println("Account Number: "+Premiumcount++);
                                System.out.println("Account Balance: "+initialDeposite2);
                            }
                            else {
                                System.out.println("Something Is Wrong Try Again!");
                            }
                            break;
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    int accountnum = sc.nextInt();
                    System.out.print("Enter Amount To Deposite!");
                    int amount = sc.nextInt();
                    if (bankManager.depositeMoney(accountnum,amount)) {
                        System.out.println("Amount Deposited Successfully!");
                    }
                    else {
                        System.out.println("No Account Found!");
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Sender Account Number: ");
                    int sender = sc.nextInt();
                    System.out.print("Enter Receiever Account Number: ");
                    int receiever = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    int Sendamount = sc.nextInt();
                    System.out.println("============================================");
                    showModes();
                    System.out.print("Choose Option: ");
                    int choices = sc.nextInt();
                    PaymentMethods methods;
                    Account a;
                    switch (choices) {
                        case 1:
                            methods = new UPI();
                            a = bankManager.sendMoney(sender,receiever,Sendamount,methods);
                            System.out.println("Updated Balance: "+a.getBalance());
                            a.setHistory(" # Sender ID: "+sender+" Sended "+Sendamount+"$ To Receiver ID: "+receiever);
                            break;
                        case 2:
                            methods = new CreditCard();
                            a = bankManager.sendMoney(sender,receiever,Sendamount,methods);
                            System.out.println("Updated Balance: "+a.getBalance());
                            a.setHistory(" # Sender ID: "+sender+" Sended "+Sendamount+"$ To Receiver ID: "+receiever);
                            break;
                        case 3:
                            methods = new NetBanking();
                            a = bankManager.sendMoney(sender,receiever,Sendamount,methods);
                            System.out.println("Updated Balance: "+a.getBalance());
                            a.setHistory(" # Sender ID: "+sender+" Sended "+Sendamount+"$ To Receiver ID: "+receiever);
                            break;
                    }
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    Account acc = bankManager.findAccount(accountNumber);
                    if (acc != null) {
                        System.out.println("Account Holder Name: "+acc.getAccountHolderName());
                        System.out.println("Balance: "+acc.getBalance());
                        System.out.println("Account Type: "+acc.accountType());
                        System.out.println("history");
                        for (String i: acc.getHistory()) {
                            if (i == null) {
                            }
                            else {
                                System.out.println(i);
                            }
                        }
                    }
                    else {
                        System.out.println("No Account Found!");
                    }
                    break;
                case 5:
                    System.out.println("Thank You Bye!");
                    isRun = false;
                    break;
            }
        }

    }
}
