package User;

import Account.IAccount;
import Bill.ElectricityBill;
import Bill.GasBill;
import Bill.IBill;
import BankDummydata.Bank;
import Bill.WaterBill;
import VerificationService.BankVerification;
import BillData.BankUserBills;


import java.util.List;
import java.util.Scanner;

public class BankUser extends User {
    private String bankName;
    private String bankAccount;
    private String mobileNumber;
    List<IBill> bills = BankUserBills.initializeBills();


    public BankUser(String username, String password, String bankName, String bankAccount, String mobileNumber, IAccount Account) {
        super(username, password, Account);
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.mobileNumber = mobileNumber;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankname) {
        bankName=bankname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobnum) {
        mobileNumber=mobnum;
    }


    public double getBalance() {
        return getAccount().getBalance();
    }
    public String getBankAccount()
    {
        return bankAccount;
    }
    public void setBankAccount(String bankaccount)
    {
        bankAccount=bankaccount;
    }




    public void signUp(List<Bank> banks) {
        if (getUsername() == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Signing up Bank user...");

            // Prompt the user for username
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            // Prompt the user for password
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // Prompt the user for the bank name
            System.out.print("Enter Bank Name: ");
            String bankName = scanner.nextLine();

            // Prompt the user for the bank account details as a string
            System.out.print("Enter Bank Account (as a string): ");
            String bankAccount = scanner.nextLine();

            // Prompt the user for the mobile number
            System.out.print("Enter Mobile Number: ");
            String mobileNumber = scanner.nextLine();
            setUsername(username);
            setPassword(password);
            setBankName(bankName);
            setBankAccount(bankAccount);
            setMobileNumber(mobileNumber);

            // Check if the entered bank details exist in the list
            if (isBankValid(bankName, bankAccount, banks)) {
                setUsername(username);
                setPassword(password);

                System.out.println("Account Available in bank "+bankName);
                System.out.println("----------------------------------");



                BankVerification bankv = new BankVerification();
                boolean verified = bankv.verifyOTP(mobileNumber);
                if (verified) {
                    System.out.println("Bank user signed up successfully.");
                    System.out.println("----------------------------------");
                    System.out.println("Your Profile");

                    System.out.println("Username: " + getUsername());
                    System.out.println("Password: " + getPassword());
                    System.out.println("Bank Name: " + bankName);
                    System.out.println("Bank Account: " + bankAccount);
                    System.out.println("Mobile Number: " + mobileNumber);
                    System.out.println("----------------------------------");


                } else {
                    System.out.println("OTP verification failed. Bank user not signed up.");
                }
            } else {
                System.out.println("Invalid bank details. Bank user not signed up.");
            }

        } else {
            System.out.println("Bank user is already registered.");
        }

    }

    // Method to check if the entered bank details exist in the list
    private boolean isBankValid(String bankName, String bankAccount, List<Bank> banks) {
        for (Bank bank : banks) {
            if (bank.getBankName().equalsIgnoreCase(bankName) && bank.getBankAccount().equals(bankAccount)) {
                return true; // Bank details are valid
            }
        }
        return false; // Bank details are not found in the list
    }
    public void checkBills(List<IBill> bills) {
        // Check bills associated with the user's account number
        for (IBill bill : bills) {
            if (bill.getAccountNumber().equals(bankAccount)) {
                if (bill instanceof GasBill) {
                    System.out.println("You have a Gas bill with amount $" + bill.getAmount());
                } else if (bill instanceof WaterBill) {
                    System.out.println("You have a Water bill with amount $" + bill.getAmount());
                } else if (bill instanceof ElectricityBill) {
                    System.out.println("You have an Electricity bill with amount $" + bill.getAmount());
                } else {
                    System.out.println("You have a bill with amount $" + bill.getAmount());
                }
            }
        }
    }




    @Override
    public void payBill(IBill bill) {
        // Implement bill payment logic for bank user
        bill.payBill(this);
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Bank Name: " + getBankName());
        System.out.println("Bank Account: " + getBankAccount());
        System.out.println("Mobile Number: " + getMobileNumber());
        System.out.println("Balance: $" + getAccount().getBalance());
        if (bills != null) {
           checkBills(bills);
        } else {
            System.out.println("No bills available.");
        }
    }
}
