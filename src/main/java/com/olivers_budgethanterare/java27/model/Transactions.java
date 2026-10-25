package com.olivers_budgethanterare.java27.model;

import java.time.LocalDate;
import java.util.*;

public class Transactions {

    public enum TransactionType{
        INCOME,
        EXPENSE
    }

    public record TransactionInformation(String date, TransactionType transactionType, int moneyAmount,String message){}

     static ArrayList<TransactionInformation> newTransactions = new ArrayList<>();


    static void main(){
        addRandomTransactions();
        //filterTransactions();
        combineValueOfEnumType();
    }


    //--------------------------------------------------------
    //Methods for creating Transaction
    public static void addTransaction(TransactionType transactionType, int  moneyAmount, String message){

        String date = String.valueOf(LocalDate.now());
        //TransactionType transactionType = pickTransactionType();
        //int moneyAmount = pickMoneyAmount();
        //String category = IO.readln("Skriv en kommentar om du vill");

        TransactionInformation newTransaction = new TransactionInformation(date, transactionType, moneyAmount, message);
        IO.println("Transaktionen har tillagts: " + newTransaction.date + " " +  newTransaction.transactionType +
                    " " + newTransaction.moneyAmount + " " + newTransaction.message);


        newTransactions.add(newTransaction);
    }


    public static int pickMoneyAmount(){
        int moneyAmount = 0;
        while(moneyAmount < 1) {
            try {
                moneyAmount = Integer.parseInt(IO.readln("Vad var beloppet, kan inte vara 0:"));
            } catch (NumberFormatException e) {
                IO.println("Error: Måste använda numer under inmatningen");
            }

            if(moneyAmount < 1) {
                moneyAmount =- (moneyAmount);
            }
        }
        return moneyAmount;
    }

    public static TransactionType pickTransactionType(){
        int menuNav = 0;
        while(menuNav != 1 && menuNav != 2) {
            IO.println("Var transaktionen en utgift eller inkomst?");
            IO.println("1. Utgift");
            IO.println("2. Inkomst");
            try{
                menuNav = Integer.parseInt(IO.readln("Välj mellan 1 och 2 "));
            }catch(NumberFormatException e){
                IO.println("Error: Måste använda numer under inmatningen");
                IO.println("Försök igen");
            }

        }

        if (menuNav == 1){
            return TransactionType.EXPENSE;
        }
            return TransactionType.INCOME;
    }

    //----------------------------------------------------------------------
    //Methods to print Transactions
    public static void printTransactions(){
        newTransactions.forEach(transaction -> IO.println(transaction.date + " " + transaction.transactionType +
                " " + transaction.moneyAmount + " " + transaction.message));
    }

    public static void filterTransactions(){
        int nav = 0;
        while (nav < 1 || nav > 4){
        IO.println("-----------------------------");
        IO.println("Vad vill du filtrera");
        IO.println("1. datum");
        IO.println("2. inkomst/utkomst över x");
        IO.println("3. inkomst/utkomst under x");
        IO.println("4. meddelanden");


        try{
            nav = Integer.parseInt(IO.readln());
        }catch (NumberFormatException e){
            nav = 0;
        }
        }
        int moneyFilter = 0;
        switch (nav){
            case 1:
                String dateFilter = IO.readln("Skriv in ditt filter");
                dateFilter(dateFilter);
                break;
            case 2:
                while(moneyFilter == 0) {
                    try {
                        moneyFilter = Integer.parseInt(IO.readln("Skriv numer at filtrera"));
                    } catch (NumberFormatException e) {
                        moneyFilter = 0;
                        IO.println("Error: ogiltigt input filter sätts automatiskt till 0");
                    }
                }
                moneyFilterUpwards(moneyFilter);
                break;
            case 3:
                while(moneyFilter == 0) {
                    try {
                        moneyFilter = Integer.parseInt(IO.readln("Skriv numer at filtrera"));
                    } catch (NumberFormatException e) {
                        moneyFilter = 0;
                        IO.println("Error: ogiltigt input filter sätts automatiskt till 0");
                    }
                }
                moneyFilterDownwards(moneyFilter);
                break;
            case 4:
                String messageFilter = IO.readln("Skriv in ditt filter");
                messagesFilter(messageFilter);
                break;
        }


    }

    //-----------------------------------
    //Different filter functions
    static void dateFilter(String filter){
        newTransactions.stream()
                .filter(date -> date.date.contains(filter))
                .forEach(date -> IO.println(date.date + " " + date.transactionType +
                " " + date.moneyAmount + " " + date.message));
    }

    static void messagesFilter(String filter){
        newTransactions.stream()
                .filter(message -> message.message.contains(filter))
                .forEach(message -> IO.println(message.date + " " + message.transactionType +
                        " " + message.moneyAmount + " " + message.message));
    }

    static void moneyFilterUpwards(int filter){
        int nav = 0;
        while (nav < 1 || nav > 3) {
            IO.println("1. Om du vill see alla resultat");
            IO.println("2. Om du vara bara vill see utgifter");
            IO.println("3. Om du bara vill see utgifter");
            try{
                nav = Integer.parseInt(IO.readln());
            }catch(NumberFormatException e){
                nav = 0;
                IO.println("Error: Ogiltigt input");
            }
        }
        switch (nav) {
            case 1:
            newTransactions.stream()
                    .filter(money -> money.moneyAmount >= filter)
                    .forEach(money -> IO.println(money.date + " " + money.transactionType +
                            " " + money.moneyAmount + " " + money.message));
                break;
            case 2:
                newTransactions.stream()
                        .filter(money -> money.moneyAmount >= filter)
                        .filter(money -> money.transactionType.equals(TransactionType.EXPENSE))
                        .forEach(money -> IO.println(money.date + " " + money.transactionType +
                                " " + money.moneyAmount + " " + money.message));
                break;
            case 3:
                newTransactions.stream()
                        .filter(money -> money.moneyAmount >= filter)
                        .filter(money -> money.transactionType.equals(TransactionType.INCOME))
                        .forEach(money -> IO.println(money.date + " " + money.transactionType +
                                " " + money.moneyAmount + " " + money.message));
                break;
        }
    }

    static void moneyFilterDownwards(int filter){
        int nav = 0;
        while (nav < 1 || nav > 3) {
            IO.println("1. Om du vill see alla resultat");
            IO.println("2. Om du vara bara vill see utgifter");
            IO.println("3. Om du bara vill see inkomst");
            try{
                nav = Integer.parseInt(IO.readln());
            }catch(NumberFormatException e){
                nav = 0;
                IO.println("Error: Ogiltigt input");
            }
        }
        switch (nav) {
            case 1:
                newTransactions.stream()
                        .filter(money -> money.moneyAmount <= filter)
                        .forEach(money -> IO.println(money.date + " " + money.transactionType +
                                " " + money.moneyAmount + " " + money.message));
                break;
            case 2:
                newTransactions.stream()
                        .filter(money -> money.moneyAmount <= filter)
                        .filter(money -> money.transactionType.equals(TransactionType.EXPENSE))
                        .forEach(money -> IO.println(money.date + " " + money.transactionType +
                                " " + money.moneyAmount + " " + money.message));
                break;
            case 3:
                newTransactions.stream()
                        .filter(money -> money.moneyAmount <= filter)
                        .filter(money -> money.transactionType.equals(TransactionType.INCOME))
                        .forEach(money -> IO.println(money.date + " " + money.transactionType +
                                " " + money.moneyAmount + " " + money.message));
                break;
        }
    }

    //--------------------------------------------------------------
    //Methods för att sammanställa all värden av INCOME eller EXPENSE
    public static void combineValueOfEnumType(){
        int nav = 0;
        IO.println("1. Om du vill see värdet av din inkomst");
        IO.print("2. Om du vill see kostnaden på dina utgifter");

        while(nav != 1 && nav != 2){
            try{
                nav = Integer.parseInt(IO.readln());
            }catch(NumberFormatException e){
                nav = 0;
                IO.println("Error: Ogiltigt input");
            }
            if(nav != 1 && nav != 2){
                IO.println("Var vänlig välj ett giltigt menyval");
            }
        }

        if (nav == 1){
            var sum = newTransactions.stream()
                    .filter(income -> income.transactionType.equals(TransactionType.INCOME))
                    .map(income -> income.moneyAmount)
                    .reduce(0, Integer::sum)
                    .intValue();

            IO.println("Din totala inkomst liger på " + sum);
        }
        else{
            var sum = newTransactions.stream()
                    .filter(expense -> expense.transactionType.equals(TransactionType.EXPENSE))
                    .map(expense -> expense.moneyAmount)
                    .reduce(0, Integer::sum)
                    .intValue();

            IO.println("Din totala utkomst liger på " + sum);
        }

    }

    //-----------------------------------------------------------
    //Method for testing because array starts out empty
    public static void addRandomTransactions(){
        String date = String.valueOf(LocalDate.now());
        TransactionInformation newTransaction = new TransactionInformation(
                date, TransactionType.INCOME, 27490, "Nej");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.INCOME, 87738, "Inget jag vill säga");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.EXPENSE, 58705, "Vet du vad");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.EXPENSE, 91258, "Kommer nog att säga något snart");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.INCOME, 35987, "Snart kommer det");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.EXPENSE, 7680, "Hej");
        newTransactions.add(newTransaction);
    }
}




