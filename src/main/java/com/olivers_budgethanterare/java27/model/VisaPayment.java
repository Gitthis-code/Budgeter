package com.olivers_budgethanterare.java27.model;

import com.olivers_budgethanterare.java27.Budgeter;

public class VisaPayment extends CardPayment{


    public VisaPayment(Budgeter.ExpirationDate expirationDate, Budgeter.CardOwner cardOwner, String cardNumber, int cvv){
        this.expiration = expirationDate;
        this.cardOwner = cardOwner;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
}
