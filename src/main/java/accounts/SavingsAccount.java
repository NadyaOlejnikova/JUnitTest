package accounts;

public class SavingsAccount extends Account {

    protected long minBalance;

    public SavingsAccount(String name, long balance, long minBalance) {
        super(name, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void setBalance(long balance) {
        if (balance > minBalance) {
            super.setBalance(balance);
        }
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount >= minBalance) {
            return super.pay(amount);
        }
        return false;
    }


    @Override
    public String toString() {
        return "Накопительный счет " + balance + "  баланс";
    }

    @Override
    public boolean accept(int money) {
        if (money > 0) {
            balance += money;
            System.out.println("Накопительный счет пополнен на сумму: " + money + " баланс равен: " + balance);
            return true;
        }
        System.out.println("Пополнение невозможно! " + money + " баланс равен: " + balance);
        return false;
    }
}




