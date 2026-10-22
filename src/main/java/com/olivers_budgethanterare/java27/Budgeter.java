package com.olivers_budgethanterare.java27;

import com.olivers_budgethanterare.java27.model.Transactions;

import java.util.concurrent.TimeUnit;

public class Budgeter {


    static void main(){
        menu("burg", "gurk");
    }

    public static void menu(String password, String user) {

        boolean running = true;
        int choice;

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
                    Transactions.addTransaction(user);
                    break;
                case 2:
                    Transactions.filterTransactions();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    running = false;
                    break;

            }

            if(choice < 1 || choice > 6){
                IO.println("Inte en giltig inmatning");
                IO.println();

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }


    }
}
