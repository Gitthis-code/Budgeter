package com.olivers_budgethanterare.java27.model;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class usersCredentialsTest {




    @Test
    void newUsersPasswordShouldBeLonger(){
        var usersCredentials = new usersCredentials();

        assertFalse(usersCredentials.createAccount("David", "Short"));

    }

    @Test
    void newUsersCreated(){
        var usersCredentials = new usersCredentials();

        String username = "David";
        String password = "PasswordIs8CharactersOrLonger";
        usersCredentials.createAccount(username, password);
        assertEquals("David", usersCredentials.usersCredentials.get(password));
    }

    @Test
    void checkTrueCredentials(){
        var usersCredentials = new usersCredentials();


        usersCredentials.usersCredentials.put("Admin", "TestUser");

        assertTrue(usersCredentials.checkCredentials("TestUser", "Admin"));
    }

    @Test
    void checkFalsePassword(){
        var usersCredentials = new usersCredentials();


        usersCredentials.usersCredentials.put("Admin", "TestUser");

        assertFalse(usersCredentials.checkCredentials("Admin", "falsePassword"));
    }

    @Test
    void checkFalseName(){
        var usersCredentials = new usersCredentials();


        usersCredentials.usersCredentials.put("Admin", "TestUser");

        assertFalse(usersCredentials.checkCredentials("Aimn", "TestUser"));
    }
}