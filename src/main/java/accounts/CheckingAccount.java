package accounts;



public class CheckingAccount extends Account {
    private long minBalance;

    public CheckingAccount(String name, long balance, long minBalance) {
        super(name, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void setBalance(long balance) {
        if (balance > 0) {
            super.setBalance(balance);
        }
    }

    @Override
    public boolean pay(long amount) {
        if (balance > minBalance) {
            return super.pay(amount);
        }
        return false;
    }

    @Override
    public boolean add(long amount) {
        return super.add(amount);
    }

    @Override
    public String toString() {
        return "Расчетный счет " + balance + "   баланс";
    }

    @Override
    public boolean accept(int money) {
        if (money > 0) {
            balance += money;
            System.out.println("Расчетный счет пополнен на сумму: " + money + " баланс равен: " + balance);
            return true;
        }
        System.out.println("Пополнение на сумму: " + money + "невозможно");
        return false;
    }
}


