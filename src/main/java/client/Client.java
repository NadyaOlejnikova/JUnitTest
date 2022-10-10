package client;

import accounts.Account;
import accounts.MoneyTarget;

public class Client implements MoneyTarget {
    protected String name;
    protected Account[] accounts;

    public Client(String name, int maxAccountLength) {
        accounts = new Account[maxAccountLength];
        this.name = name;
    }

    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Мест для добавления нового счёта нет! :(");
    }

    public boolean pay(int amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].pay(amount)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(int money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].add(money)) {
                System.out.println("Сумма в размере " + money + " руб " + "переведена на " + accounts[i]);
                return true;
            }
        }
        return false;

    }
}



