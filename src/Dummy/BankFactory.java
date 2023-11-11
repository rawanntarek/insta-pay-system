package Dummy;

import java.util.ArrayList;
import java.util.List;

public class BankFactory {

    public static List<Bank> createBanks() {
        List<Bank> banks = new ArrayList<>();

        // Bank 1
        ConcreteBank NBE = new ConcreteBank("AlahlyBank");
        NBE.addBankUser(new User.BankUser("User1", "12345", "NBE", "1234567890","021245488"));
        NBE.addBankUser(new User.BankUser("User2", "500360", "NBE", "9876543210","336498565"));
        banks.add(NBE);

        // Bank 2
        ConcreteBank BankMisr = new ConcreteBank("BankMisr");
        BankMisr.addBankUser(new User.BankUser("User3", "12345", "BankMisr", "1234567890","25485568556"));
        BankMisr.addBankUser(new User.BankUser("User4", "503552", "BankMisr", "65465847564","2.56856598"));
        banks.add(BankMisr);

        // Bank 3
        ConcreteBank QNB = new ConcreteBank("QNB");
        BankMisr.addBankUser(new User.BankUser("User5", "45645", "QNB", "54445645458","36596362659"));
        BankMisr.addBankUser(new User.BankUser("User6", "56569", "QNB", "52458478798","3265896525689"));
        banks.add(QNB);

        return banks;
    }
}