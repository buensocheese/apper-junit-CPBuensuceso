package com.gcash;
public class BalanceService {

    public void debit(double currentBalance, double amount) throws InsufficientBalanceException {
        if (currentBalance >= amount) {
            double newBalance = currentBalance - amount;
            // Update the balance in the account
        } else {
            throw new InsufficientBalanceException("Insufficient balance");
        }
    }

    public void credit(double currentBalance, double amount) {
        double newBalance = currentBalance + amount;
        // Update the balance in the account
    }

    public void transfer(double sourceBalance, double destinationBalance, double amount) throws InsufficientBalanceException {
        if (sourceBalance >= amount) {
            debit(sourceBalance, amount);
            credit(destinationBalance, amount);
        } else {
            throw new InsufficientBalanceException("Insufficient balance in the source account");
        }
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
