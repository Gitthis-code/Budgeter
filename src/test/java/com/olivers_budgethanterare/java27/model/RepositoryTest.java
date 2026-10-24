package com.olivers_budgethanterare.java27.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import static com.olivers_budgethanterare.java27.model.Repository.savePath;
import static com.olivers_budgethanterare.java27.model.Transactions.newTransactions;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {


    @Test
    void checkForFileNullRejection() {
        var Repository = new Repository();

        String nullPath  = null;
        Assertions.assertEquals(Repository.checkForFile(nullPath), null);

    }

    @Test
    void assertThatFileExists() throws IOException {
        var Repository = new Repository();

        String fileName = "Tester";
        Path testFile = Repository.createFile(fileName);

        assertTrue(Files.exists(testFile));
    }

    @Test
    void assertThatFileWithCustomNameExists() throws IOException {
        var Repository = new Repository();

        String userName = "Tester";
        Path testFile = Repository.createFileWithCustomName(userName);

        assertTrue(Files.exists(testFile));
    }

    @Test
    void EmptyTransactionsArrayAfterWritingToFile(){
        var Repository = new Repository();

        Transactions.TransactionInformation newTransaction = new Transactions.TransactionInformation(
                "2089.05.06", Transactions.TransactionType.INCOME, 35987, "Tester");
        newTransactions.add(newTransaction);

        Path filePath = savePath.resolve("Tester.txt");
        Repository.insertTransactionsArrayIntoFile(filePath);
        assertTrue(newTransactions.isEmpty());
    }

    @Test
    void TransactionsArrayNotEmptyingOnFalsePath(){
        var Repository = new Repository();

        Transactions.TransactionInformation newTransaction = new Transactions.TransactionInformation(
                "2089.05.06", Transactions.TransactionType.INCOME, 35987, "Tester");
        newTransactions.add(newTransaction);

        Path filePath = savePath.resolve("NotRealFile.txt");
        Repository.insertTransactionsArrayIntoFile(filePath);
        assertFalse(newTransactions.isEmpty());
    }

}