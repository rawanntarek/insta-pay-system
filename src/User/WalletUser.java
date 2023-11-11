package User;

import java.util.Scanner;

public class WalletUser extends User {
    private String mobileNumber;

    public WalletUser(String username, String password, String mobileNumber) {
        super(username, password);
        this.mobileNumber = mobileNumber;
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
            System.out.println("Wallet user signed up successfully.");

            // Close the scanner
            scanner.close();
        } else {
            System.out.println("Wallet user is already registered.");
        }
    }

    @Override
    public void displayAdditionalDetails() {
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Account Type: Wallet");
    }
}