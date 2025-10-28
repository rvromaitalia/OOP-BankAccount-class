package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount; // <-- field visible to all tests
    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(
                "SE12345",
                "Roman Vanoyan",
                 new BigDecimal(0),
                "swederom@msn.com",
                "07600333198");
    }
    @Test
    void getAccountNumber() {
        String exString = "SE12345";
        assertEquals(exString, bankAccount.getAccountNumber());
        bankAccount.setAccountNumber("SE4569");
        assertEquals("SE4569", bankAccount.getAccountNumber() );
    }

   @Test
    void setAccountNumber() {
        bankAccount.setAccountNumber("SE123590");
        assertEquals("SE123590", bankAccount.getAccountNumber());
    }

    @Test
    void getCustomerName() {
        bankAccount.getCustomerName();
        assertEquals("Roman Vanoyan",bankAccount.getCustomerName());
        bankAccount.setCustomerName("Michael Bloom");
        assertEquals("Michael Bloom", bankAccount.getCustomerName());
    }

    @Test
    void setCustomerName() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void setBalance() {
    }

    @Test
    void getPhoneNumber() {
    }

    @Test
    void setPhoneNumber() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void setEmail_acceptBasicAddress() {
        bankAccount.setEmail("swederom@msn.com");
        assertEquals("swederom@msn.com",bankAccount.getEmail());
    }

    @Test
    void setEmail_throwsNull_with_message() {
        var ex = assertThrows(IllegalArgumentException.class, () -> bankAccount.setEmail(null));
        assertEquals("Invalid email address", ex.getMessage());;
    }

    @Test
    void deposit_negative_amount() {
        var ex = assertThrows(IllegalArgumentException.class, ()->bankAccount.deposit(-10.5));
        assertEquals("Amount can not be 0 or 'negative'",ex.getMessage());
    }

    @Test
    void deposit_amount_normal_case() {
        bankAccount.deposit(5000);
        assertEquals(BigDecimal.valueOf(5000).setScale(2), bankAccount.getBalance());
    }

    @Test
    void withdraw() {
    }
}