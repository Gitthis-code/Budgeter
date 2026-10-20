package com.olivers_budgethanterare.java27.model;

import com.olivers_budgethanterare.java27.Budgeter;

public class CardPayment extends Transactions{

    Budgeter.ExpirationDate expiration;
    Budgeter.CardOwner cardOwner;
    String cardNumber;
    int cvv;

    public boolean CardNumberValidityCheck(String cardNumber){
        if(cardNumber.matches("[0-9]{16}")){
            IO.readln("Ogiltigt kortnummer var vänlig försök igen");
        }

        return true;
    }

    public boolean CardExpirationDateValidityCheck(Budgeter.ExpirationDate expirationDate){

        if(expirationDate.expirationMonth() > 12 || expirationDate.expirationMonth() < 1){
            IO.println("Ogiltig utgångs månad");
            return false;
        }

       if(expirationDate.expirationYear() > 99 || expirationDate.expirationYear() < 1){
           IO.println("Ogiltigt utgångs år");
           return false;
       }


        return true;
    }

    public boolean CvvValidityCheck(int cvv){
        if(cvv != 3){
            return false;
        }
        return true;
    }

}
