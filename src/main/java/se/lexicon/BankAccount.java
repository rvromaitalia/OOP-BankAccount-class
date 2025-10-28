package se.lexicon;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankAccount {
    private String accountNumber;
    private String customerName;
    private BigDecimal balance;
    private String email;
    private String phoneNumber;
    private int accountCounter = 0;

    public BankAccount(String accName, String cName, BigDecimal balance, String email, String pNumber) {
        this.accountNumber = accName;
        this.customerName = cName;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = pNumber;

    }

    //define setters and getters for fields

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        // Normalize money to 2 decimals (optional but recommended for currency)
        BigDecimal normalized = balance.setScale(2, RoundingMode.HALF_UP);
        if (normalized.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Balance can not be negative");

        this.balance = normalized;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email address");
        this.email = email;
    }

    private void requiresGreaterThanZero(double amount) {
        if (!Double.isFinite(amount) || amount <= 0.0) {
            throw new IllegalArgumentException("Amount can not be 0 or 'negative'");
        }
    }

    /**
     * Adds money to the account.
     *
     * @param amount amount to deposit (must be > 0)
     * @throws IllegalArgumentException if the amount is invalid
     */
    public void deposit(double amount) {
        requiresGreaterThanZero(amount);
        this.setBalance(getBalance().add(BigDecimal.valueOf(amount)));
    }

    /**
     * Withdraws money from balance
     *
     * @param amount amount to withdraw (must be non-negative and >0 balance value)
     * @throws IllegalArgumentException if "amount" is invalid
     */

    public void withdraw(double amount) {
        requiresGreaterThanZero(amount);
        BigDecimal normalizedAmount = BigDecimal.valueOf(amount);

        boolean sufficient = (getBalance().compareTo(normalizedAmount) >= 0);
        if (sufficient){
            balance = balance.subtract(normalizedAmount);
    }   else {
        System.out.println("Your don't have enough money to complete this transaction");
    }
}
}
