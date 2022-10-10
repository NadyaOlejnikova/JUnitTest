import accounts.*;
import client.Client;

public class Main {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(" ", 0, 0);
        checkingAccount.setName("Ivanov");
        checkingAccount.setBalance(1000);
        checkingAccount.add(1000);
        checkingAccount.pay(0); // не платит, если нет денег
        System.out.println("Фамилия: " + checkingAccount.getName() +
                "  На счету у клиента: " + checkingAccount.getBalance() + " руб");

        CreditAccount creditAccount = new CreditAccount(" ", 0);
        creditAccount.setName("Petrov");
        creditAccount.setBalance(-500);
        creditAccount.add(1000);
        creditAccount.pay(1000);
        System.out.println("Фамилия: " + creditAccount.getName() +
                "  На счету у клиента: " + creditAccount.getBalance() + " руб");

        SavingsAccount savingsAccount = new SavingsAccount(" ", 0, 1000);
        savingsAccount.setName("Sidorov");
        savingsAccount.setBalance(3000);
        savingsAccount.add(1000);
        savingsAccount.pay(1000);
        System.out.println("Фамилия: " + savingsAccount.getName() +
                "  На счету у клиента: " + savingsAccount.getBalance() + " руб");

        Client client = new Client("Nadya", 5);
        client.add(creditAccount);
        client.add(checkingAccount);
        client.add(checkingAccount);
        client.add(savingsAccount);
        client.add(savingsAccount);
        client.add(checkingAccount);
        //       System.out.println(client.pay(10000));

        savingsAccount.transfer(checkingAccount, 1000);
        checkingAccount.transfer(creditAccount, 5000);
        creditAccount.transfer(savingsAccount, 7000);
        creditAccount.accept(1000);
        savingsAccount.accept(1000);
        checkingAccount.accept(1000);
        client.accept(7000);
    }

}
