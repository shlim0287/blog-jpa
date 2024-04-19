package com.estsoft.blogjpa.domain;

public class Account {

    private int balance;
    public Account(int i) {
        this.balance=i;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int i) {
        balance=balance+i;
    }
}
