package accounts;

public class CreditAccount extends Account {

    public CreditAccount(String name, long balance) {
        super(name, balance);
    }

    @Override
    public void setBalance(long balance) {
        if (balance <= 0) {
            super.setBalance(balance);
        } else {
            return;
        }
    }

    @Override
    public boolean add(long amount) {
        if (balance + amount <= 0) {
            return super.add(amount);
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        if (balance <= 0) {
            if (amount >= balance && amount > 0) { // для кредита
                balance -= amount;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Кредитный счет  " + balance + "   баланс";
    }

    @Override
    public boolean accept(int money) {
        if (balance + money <= 0) {
            balance += money;
            System.out.println("Кредитный счет пополнен на сумму: " + money + "  баланс равен:" + balance);
            return true;
        }
        System.out.println("Пополнение кредитного счета на сумму: " + money + "   невозможно");
        return false;
    }

}

