package User;

import Account.IAccount;
import Bill.IBill;
import VerificationService.BankVerification;
import VerificationService.IVerification;
import VerificationService.WalletVerification;

import java.util.Scanner;

public class WalletUser extends User {
    private String mobileNumber;


    public WalletUser(String username, String password, String mobileNumber, IAccount Account) {
        super(username, password,Account);
        this.mobileNumber = mobileNumber;
    }

    public double getBalance(){
        return getAccount().getBalance();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public void signUp() {
        if (getUsername() == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Signing up Wallet user...");

            // Prompt the user for username
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            // Prompt the user for password
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // Prompt the user for the mobile number
            System.out.print("Enter Mobile Number: ");
            mobileNumber = scanner.nextLine();

            setUsername(username);
            setPassword(password);

            System.out.println("Username: " + getUsername());
            System.out.println("Password: " + getPassword());
            System.out.println("Mobile Number: " + mobileNumber);
            if (isValidAccount(mobileNumber)
            {
                System.out.println("Wallet account available.");
                boolean verified = bankv.verifyOTP(mobileNumber);
            if (verified) {
                System.out.println("Wallet user signed up successfully.");
            } else {
                System.out.println("OTP verification failed. Bank user not signed up.");
            }

            }
            else {
                System.out.println("Invalid Wallet account.")
            }
            



        } else {
            System.out.println("Wallet user is already registered.");
        }
    }
    private boolean isValidAccount(String accountNumber) {
        // Check if the entered account number exists in the in-memory bank database
        return WalletDataBAse.getAccounts().stream()
                .anyMatch(account -> account.getAccountNum().equals(accountNumber));
    }

    @Override
    public void payBill(IBill bill) {
        // Implement bill payment logic for wallet user
        bill.payBill(this);
    }


}