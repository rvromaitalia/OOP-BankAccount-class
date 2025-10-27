package se.lexicon;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        BankAccount bankAccount = new BankAccount("SE12345", "Roman Vanoyan", new BigDecimal(0),
                "swederom@msn.com", "07600333198");
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("Balance: " + bankAccount.getBalance());
        System.out.println("Customer name: " + bankAccount.getCustomerName());
        System.out.println("Email: " + bankAccount.getEmail());
        System.out.println("Phone number: " + bankAccount.getPhoneNumber());

        bankAccount.setBalance(new BigDecimal(5000));
        System.out.println("Balance: " + bankAccount.getBalance());

        bankAccount.setBalance(new BigDecimal(-7));
        System.out.println("Balance: " + bankAccount.getBalance());


    }
}
