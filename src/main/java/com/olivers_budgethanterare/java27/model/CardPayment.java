package com.olivers_budgethanterare.java27.model;

public class CardPayment extends Transactions{

    record cardInformation(String cardNumber, int cvv, int expirationYear, int expirationMonth, String cardOwnerName){}


}
