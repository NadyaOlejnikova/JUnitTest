package accounts;

public abstract class Account implements MoneyTarget {
    protected long balance;
    protected String name;


    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean pay(long amount) {
        if (amount <= balance && amount > 0) { // баланс больше или равно суммы платежа
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean add(long amount) {
        if (amount > 0) { // сумма платежа есть+
            balance += amount;
            return true;
        }
        return false;
    }

    public abstract String toString();

    public boolean transfer(Account accountTo, int amount) {
        if (pay(amount)) {
            if (accountTo.add(amount)) {
                return true;
            } else {
                add(amount);
            }
        } else {
            return false;
        }
        return false;
    }
}
