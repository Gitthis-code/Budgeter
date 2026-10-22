package com.olivers_budgethanterare.java27.model;

import com.olivers_budgethanterare.java27.Budgeter;

public class CardPayment extends Transactions{

    Budgeter.ExpirationDate expiration;
    Budgeter.CardOwner cardOwner;
    String cardNumber;
    String cvv;

    public boolean CardNumberValidityCheck(String cardNumber){
        if(!cardNumber.matches("[0-9]{16}")){
            IO.readln("Ogiltigt kortinformation var vänlig försök igen");
            return false;
        }

        return true;
    }

    public boolean CardExpirationDateValidityCheck(Budgeter.ExpirationDate expirationDate){

        if(expirationDate.expirationMonth() > 12 || expirationDate.expirationMonth() < 1){
            IO.println("Ogiltigt kortinformation var vänlig försök igen");
            return false;
        }

       if(expirationDate.expirationYear() > 99 || expirationDate.expirationYear() < 1){
           IO.println("Ogiltigt kortinformation var vänlig försök igen");
           return false;
       }


        return true;
    }

    public boolean CvvValidityCheck(String cvv){
        if(!cvv.matches("[0-9]{3}")){
            IO.println("Ogiltigt kortinformation var vänlig försök igen");
            return false;
        }
        return true;
    }

}
