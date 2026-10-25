package com.olivers_budgethanterare.java27.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.olivers_budgethanterare.java27.model.Transactions.*;
import static org.junit.jupiter.api.Assertions.*;

class TransactionsTest {

    @Test
    void assertStoringOfTransaction(){
        var Transactions = new Transactions();



        Transactions.addTransaction(TransactionType.INCOME, 100, "Test");

        assertEquals(1, newTransactions.size());
        newTransactions.clear();
    }

    @Test
    void assertStoringOfCorrectValues(){
        var Transactions = new Transactions();


        Transactions.addTransaction(TransactionType.INCOME, 100, "Test");

        assertEquals(newTransactions.get(0).date(), String.valueOf(LocalDate.now()));
        assertEquals(TransactionType.INCOME, newTransactions.get(0).transactionType());
        assertEquals(100, newTransactions.get(0).moneyAmount());
        assertEquals("Test", newTransactions.get(0).message());
        newTransactions.clear();
    }

    @Test
    void nullInputRejected(){
        var Transactions = new Transactions();

        Transactions.addTransaction(null, 100, "Test");
        assertTrue(newTransactions.isEmpty());
    }



}