package com.olivers_budgethanterare.java27.model;


import java.util.HashMap;

public class usersCredentials{

    HashMap<String,String> usersCredentials = new HashMap<String, String>();

    public boolean createAccount(String username, String password){
        if (password.length() < 8){
            IO.println("Lösenord måste vara mins 8 tecken långt");
            return false;
        }

        usersCredentials.put(password,username);
        return true;
    }

    public boolean checkCredentials(String username, String password){
        if(usersCredentials.containsKey(password)){
            return usersCredentials.get(password).equals(username);
        }
        return false;
    }

}
