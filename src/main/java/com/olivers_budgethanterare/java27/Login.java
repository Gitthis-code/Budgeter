package com.olivers_budgethanterare.java27;

import com.olivers_budgethanterare.java27.model.usersCredentials;

import java.io.IOException;

public class Login {

    static void main() throws IOException {

        boolean loggedIn  = false;
        int menuNav;
        String name = null;
        String password = null;
        while(!loggedIn){
            IO.println("----------------------------------------------------------------");
            IO.println("Du måste logga in för att fortsätta");
            IO.println("1. Logga in");
            IO.println("2. Skapa konto");
            try{
                menuNav = Integer.parseInt(IO.readln());
            }catch(NumberFormatException e){
                menuNav = 0;
                IO.println("Snälla använd numer som input");
            }


            while(menuNav != 1 && menuNav != 2) {
                IO.println();
                IO.println("Ogiltigt val, snälla välj mellan alternativ 1 och 2");
                IO.println("1. Logga in");
                IO.println("2. Skapa konto");
                try {
                    menuNav = Integer.parseInt(IO.readln());
                } catch (NumberFormatException e) {
                    IO.println("Snälla använd numer som input");
                }
            }


                if (menuNav == 1) {
                    name = IO.readln("Skriv in ditt användarnamn");
                    password = IO.readln("Skriv ditt lösenord");

                    boolean loginCheck = usersCredentials.checkCredentials(name, password);

                    if(!loginCheck){
                        IO.println("Hittade inget konto som matchade inloggningsuppgifterna");
                    }
                    else{
                        IO.println("Välkommen tillbaka " + name);
                    }

                }else{
                    name = IO.readln("Skriv in ett användarnamn");
                    password = IO.readln("Skriv ett lösenord, lösenordet måste vara minst 8 karaktärer långt");
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

        Budgeter.menu(password, name);
    }

}
