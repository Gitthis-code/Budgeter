package com.olivers_budgethanterare.java27.model;

import java.util.ArrayList;

public class Repository<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    ArrayList<T> repository = new ArrayList<>();


    static void main(){
        Transactions.addTransaction("gurb");

    }

    public void sendTransactionToRepository(T transaction){
        repository.add(transaction);
    }
}
