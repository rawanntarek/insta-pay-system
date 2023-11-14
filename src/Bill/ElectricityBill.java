package Bill;

import InstaPayuser.User;

public class ElectricityBill implements IBill {
    private double amount;
    private String accountNumber;
    private boolean paid = false;

    @Override
    public boolean isPaid() {
        return paid;
    }

    public ElectricityBill(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void payBill(User user) {
        System.out.println("Paying Gas Bill of $" + amount + " for user: " + user.getUsername());
        user.getAccount().deductAmount(amount);
        paid=true;
    }
}
