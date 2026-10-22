package com.olivers_budgethanterare.java27.model;

import java.time.LocalDate;
import java.util.*;


public class Transactions {

    enum TransactionType{
        INCOME,
        EXPENSE
    }

    public record TransactionInformation(String date, TransactionType transactionType, int moneyAmount,String message){}

     static ArrayList<TransactionInformation> newTransactions = new ArrayList<>();


    static void main(){
        addRandomTransactions();
        printFilteredTransactions();
    }

    public static void addTransaction(String user){

        String date = String.valueOf(LocalDate.now());
        TransactionType transactionType = pickTransactionType();
        int moneyAmount = pickMoneyAmount();
        String category = IO.readln("Skriv en kommentar om du vill");

        TransactionInformation newTransaction = new TransactionInformation(date, transactionType, moneyAmount, category);
        IO.println("Transaktionen har tillagts: " + newTransaction.date + " " +  newTransaction.transactionType +
                    " " + newTransaction.moneyAmount + " " + newTransaction.message);


        newTransactions.add(newTransaction);
    }


    static int pickMoneyAmount(){
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

    static TransactionType pickTransactionType(){
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

    public static void printTransactions(){
        newTransactions.forEach(IO::println);
    }

    public static void printFilteredTransactions(){
        int nav = 0;
        while (nav < 1 || nav > 3){
        IO.println("-----------------------------");
        IO.println("Vad vill du filtrera");
        IO.println("1. datum");
        IO.println("2. inkomst/utkomst");
        IO.println("3. meddelanden");


        try{
            nav = Integer.parseInt(IO.readln());
        }catch (NumberFormatException e){
            nav = 0;
        }
        }

        switch (nav){
            case 1:
                String dateFilter = IO.readln();
                break;
            case 2:
                int moneyFilter = 0;
                try{
                    moneyFilter = Integer.parseInt(IO.readln());
                }catch (NumberFormatException e){
                   moneyFilter = 0;
                }

                break;
            case 3:
                String messageFilter = IO.readln("Skriv in ditt filter");
                messagesFilter(messageFilter);
                break;
        }


    }

    static void messagesFilter(String filter){
        IO.println("Hello");
        newTransactions.stream()
                .filter(message -> message.message.contains(filter))
                .forEach(IO::println);
    }





    public static void addRandomTransactions(){


        String date = String.valueOf(LocalDate.now());
        TransactionInformation newTransaction = new TransactionInformation(
                date, TransactionType.INCOME, 89022, "Nej");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.INCOME, 87738, "Inget jag vill säga");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.EXPENSE, 58705, "Vet du vad");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.EXPENSE, 61529, "Kommer nog att säga något snart");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.INCOME, 77876, "Snart kommer det");
        newTransactions.add(newTransaction);
        newTransaction = new TransactionInformation(
                date, TransactionType.EXPENSE, 7680, "Hej");
    }

}




