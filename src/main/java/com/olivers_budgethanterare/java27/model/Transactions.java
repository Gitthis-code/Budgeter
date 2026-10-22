package com.olivers_budgethanterare.java27.model;
import java.time.LocalDate;


public class Transactions {

    enum TransactionType{
        INCOME,
        EXPENSE
    }

    public record TransactionInformation(String date, TransactionType transactionType, int moneyAmount,String category){}

    static void main(){
        addTransaction();
    }

    public static void addTransaction(){

        String date = String.valueOf(LocalDate.now());
        TransactionType transactionType = pickTransactionType();
        int moneyAmount = pickMoneyAmount();
        String category = IO.readln("Skriv en kommentar om du vill");

        TransactionInformation newTransaction = new TransactionInformation(date, transactionType, moneyAmount, category);
        IO.println("Transaktionen har tillagts: " + newTransaction.date + " " +  newTransaction.transactionType +
                    " " + newTransaction.moneyAmount + " " + newTransaction.category);
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

}




