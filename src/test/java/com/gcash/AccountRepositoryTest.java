package com.gcash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountRepositoryTest {

    @Test
    void successfulAccountCreation() {
        // Setup
        AccountRepository repository = new AccountRepository();

        // Kick (Act)
        String accountId = repository.createAccount("Orvyl", 89.9);

        // Verify
        Assertions.assertEquals(1, repository.getNumberOfAccounts());
        Assertions.assertEquals("Orvyl", repository.getAccount(accountId).name());
        Assertions.assertNotNull(accountId);
    }

    @Test
    void successfulGetAccount() {
        // Setup
        AccountRepository repository = new AccountRepository();

        // Kick (Act)
        String accountId = repository.createAccount("Orvyl", 89.9);

        // Verify
        Assertions.assertEquals("Orvyl", repository.getAccount(accountId).name());
        Assertions.assertEquals(89.9, repository.getAccount(accountId).balance());
        Assertions.assertNull(repository.getAccount("randomid"));
    }

    @Test
    void successfulDelete() {
        // Setup
        AccountRepository repository = new AccountRepository();
        String id = repository.createAccount("Orvyl", 89.9);

        // Kick (Act)
        repository.deleteAccount(id);

        // Verify
        Assertions.assertEquals(0, repository.getNumberOfAccounts());
    }

    @Test
    void successfulGetNumberOfAccounts() {
        // Setup and Kick (Act)
        AccountRepository repository = new AccountRepository();
        String id0 = repository.createAccount("Orvyl", 89.9);
        String id1 = repository.createAccount("Orvyl", 89.9);
        String id2 = repository.createAccount("Orvyl", 89.9);
        String id3 = repository.createAccount("Orvyl", 89.9);

        // Verify
        Assertions.assertEquals(4, repository.getNumberOfAccounts());

        // Setup
        repository.deleteAccount(id0);

        // Verify
        Assertions.assertEquals(3, repository.getNumberOfAccounts());
    }

    @Test
    void checkNoRegisteredAccount() {
        // Setup
        AccountRepository repository = new AccountRepository();

        // Verify
        Assertions.assertTrue(repository.noRegisteredAccount());
    }
}
