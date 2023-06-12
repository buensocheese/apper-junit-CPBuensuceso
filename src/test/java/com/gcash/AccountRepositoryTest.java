package com.gcash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountRepositoryTest {

    private AccountRepository repository;

    @BeforeEach
    void setUp() {
        repository = new AccountRepository();
    }

    @Test
    void successfulAccountCreation() {
        // Setup
        String name = "Orvyl";
        Double initialBalance = 89.9;

        // Kick (Act)
        String accountId = repository.createAccount(name, initialBalance);

        // Verify
        Assertions.assertEquals(1, repository.getNumberOfAccounts());
        Assertions.assertEquals(name, repository.getAccount(accountId).name());
        Assertions.assertEquals(initialBalance, repository.getAccount(accountId).balance());
        Assertions.assertNotNull(accountId);
    }

    @Test
    void successfulGetAccount() {
        // Setup
        String name = "Orvyl";
        Double initialBalance = 89.9;
        String accountId = repository.createAccount(name, initialBalance);

        // Kick (Act) and Verify
        Assertions.assertEquals(name, repository.getAccount(accountId).name());
        Assertions.assertEquals(initialBalance, repository.getAccount(accountId).balance());
        Assertions.assertNull(repository.getAccount("randomid"));
    }

    @Test
    void successfulDelete() {
        // Setup
        String name = "Orvyl";
        Double initialBalance = 89.9;
        String id = repository.createAccount(name, initialBalance);

        // Kick (Act)
        repository.deleteAccount(id);

        // Verify
        Assertions.assertEquals(0, repository.getNumberOfAccounts());
    }

    @Test
    void successfulGetNumberOfAccounts() {
        // Setup
        String name = "Orvyl";
        Double initialBalance = 89.9;
        String id0 = repository.createAccount(name, initialBalance);
        String id1 = repository.createAccount(name, initialBalance);
        String id2 = repository.createAccount(name, initialBalance);
        String id3 = repository.createAccount(name, initialBalance);

        // Verify
        Assertions.assertEquals(4, repository.getNumberOfAccounts());

        // Setup
        repository.deleteAccount(id0);

        // Verify
        Assertions.assertEquals(3, repository.getNumberOfAccounts());
    }

    @Test
    void checkNoRegisteredAccount() {
        // Verify
        Assertions.assertTrue(repository.noRegisteredAccount());
    }
}