package com.olivers_budgethanterare.java27;

import com.olivers_budgethanterare.java27.model.Repository;
import com.olivers_budgethanterare.java27.model.Transactions;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.util.concurrent.TimeUnit;

public class Budgeter {


    static void main() throws IOException {
        menu("burg", "gurk");
    }

    public static void menu(String password, String user) throws IOException {

        boolean running = true;
        int choice;
        Path filePath;
        while(running){
            IO.println("--------------------------------------------------");
            IO.println("1. Lägg till transaktion");
            IO.println("2. Visa transaktioner");
            IO.println("3. Visa saldo och sammanställning per kategori");
            IO.println("4. Filtrera transaktioner");
            IO.println("5. Spara till fil");
            IO.println("6. Avsluta ");

            try{
                choice = Integer.parseInt(IO.readln("Välj ett alternativ"));
            }catch(NumberFormatException e){
                choice = 0;
            }

            switch(choice){
                case 1:
                    Transactions.TransactionType transactionType = Transactions.pickTransactionType();
                    int Money = Transactions.pickMoneyAmount();
                    String message = IO.readln("Skriv en kommentar om du vill");
                    Transactions.addTransaction(transactionType, Money, message);
                    break;
                case 2:
                    Transactions.printTransactions();
                    break;
                case 3:
                    Transactions.combineValueOfEnumType();
                    break;
                case 4:
                    Transactions.filterTransactions();
                    break;
                case 5:
                    int nav = 0;
                    boolean fileTransferCheck = false;
                    while(nav != 1 && nav != 2) {
                        IO.readln("Har du redan en fil som du vill spara till?");
                        IO.readln("1. Ja");
                        IO.readln("2. Nej");
                        try {
                            nav = Integer.parseInt(IO.readln());
                        } catch (NumberFormatException e) {
                            nav = 0;
                            IO.readln("Snälla använd nummer inom inmatningen");
                        }
                    }

                    if(nav == 1){
                        filePath = Repository.checkForFile(user);
                        if (filePath != null){
                            fileTransferCheck = Repository.insertTransactionsArrayIntoFile(filePath);
                        }
                    }
                    else if(nav == 2){
                        nav = 0;
                        while (nav != 1 && nav != 2) {
                            IO.println("Vill du välja ett eget namn på filen?");
                            IO.println("1. Ja");
                            IO.println("2. Nej");
                            try{
                                nav = Integer.parseInt(IO.readln());
                            }catch(NumberFormatException e) {
                                nav = 0;
                            }
                        }
                        if(nav == 1 ) {
                            String customName = IO.readln("Skriv namnet du vill ge filen");
                            filePath = Repository.createFileWithCustomName(customName);
                        }
                        else{
                            filePath = Repository.createFile(user);
                        }
                        fileTransferCheck = Repository.insertTransactionsArrayIntoFile(filePath);
                        }
                    if(fileTransferCheck){
                        IO.println("Överföringen gick igenom");
                    }
                    else{
                        IO.println("Det blev ett fel med överföringen försök igen");
                    }
                    break;
                case 6:
                    running = false;
                    break;

            }

            if(choice < 1 || choice > 6){
                IO.println("Inte en giltig inmatning");
                IO.println();

                /*try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }*/
            }
        }


    }
}
