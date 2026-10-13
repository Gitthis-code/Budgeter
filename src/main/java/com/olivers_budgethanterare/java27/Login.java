package com.olivers_budgethanterare.java27;

import com.olivers_budgethanterare.java27.model.usersCredentials;

public class Login {

    static void main(){

        boolean loggedIn  = false;
        int menuNav = 0;
        while(!loggedIn){
            IO.println("----------------------------------------------------------------");
            IO.println("Du måste logga in för att fortsätta");
            IO.println("1. Logga in");
            IO.println("2. Skapa konto");
            try{
                menuNav = Integer.parseInt(IO.readln());
            }catch(NumberFormatException e){
            }


            while(menuNav != 1 && menuNav != 2){
                IO.println();
                IO.println("Ogiltigt val, snälla välj mellan alternativ 1 och 2");
                IO.println("1. Logga in");
                IO.println("2. Skapa konto");
                try{
                    menuNav = Integer.parseInt(IO.readln());
                }catch(NumberFormatException e){
                }


                if (menuNav == 1) {
                    String name = IO.readln("Skriv in ditt användarnamn");
                    String password = IO.readln("Skriv ditt lösenord");

                    boolean loginCheck = usersCredentials.checkCredentials(name, password);

                    if(!loginCheck){
                        IO.println("Hittade inget konto som matchade inloggningsuppgifterna");
                    }
                    else{
                        IO.println("Välkommen tillbaka " + name);
                    }

                }else{
                    String name = IO.readln("Skriv in ett användarnamn");
                    String password = IO.readln("Skriv ett lösenord");
                    boolean accountCreationCheck = usersCredentials.createAccount(name,password);

                    if (!accountCreationCheck){
                        IO.println("Misslyckades att skapa ett konto, försök igen");
                    }
                    else{
                        IO.println("Ditt konto har blivit skapat och du kommer att loggas in ");
                        loggedIn = true;
                    }

                }

            }


        }
    }

}
