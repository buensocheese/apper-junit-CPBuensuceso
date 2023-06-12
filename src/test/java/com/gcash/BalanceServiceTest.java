package com.gcash;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BalanceServiceTest {

    @Test
    public void testDebitSufficientBalance() throws InsufficientBalanceException {
        double currentBalance = 100.0;
        double amount = 50.0;
        BalanceService balanceService = new BalanceService();

        assertDoesNotThrow(() -> balanceService.debit(currentBalance, amount));
    }

    @Test
    public void testDebitInsufficientBalance() {
        double currentBalance = 100.0;
        double amount = 150.0;
        BalanceService balanceService = new BalanceService();

        assertThrows(InsufficientBalanceException.class, () -> balanceService.debit(currentBalance, amount));
    }

    @Test
    public void testCredit() {
        double currentBalance = 100.0;
        double amount = 50.0;
        BalanceService balanceService = new BalanceService();

        balanceService.credit(currentBalance, amount);
        // Add assertions to verify the updated balance in the account
    }

    @Test
    public void testTransferSufficientBalance() throws InsufficientBalanceException {
        double sourceBalance = 100.0;
        double destinationBalance = 200.0;
        double amount = 50.0;
        BalanceService balanceService = new BalanceService();

        assertDoesNotThrow(() -> balanceService.transfer(sourceBalance, destinationBalance, amount));
        // Add assertions to verify the updated balances in the source and destination accounts
    }

    @Test
    public void testTransferInsufficientBalance() {
        double sourceBalance = 100.0;
        double destinationBalance = 200.0;
        double amount = 150.0;
        BalanceService balanceService = new BalanceService();

        assertThrows(InsufficientBalanceException.class, () ->
                balanceService.transfer(sourceBalance, destinationBalance, amount));
    }
}
