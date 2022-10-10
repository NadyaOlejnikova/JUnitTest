
import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import client.Client;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    CheckingAccount checkingAccount = new CheckingAccount("Petrov", 0, 0);
    CreditAccount creditAccount = new CreditAccount(" ", 0);
    SavingsAccount savingsAccount = new SavingsAccount(" ", 0, 1000);
    Client client = new Client("Nadya", 5);

    @Test
    @DisplayName("Пополнение счета checkingAccountAccept")
    void checkingAccountAccept() { // если баланс положительный
assertTrue(checkingAccount.accept(1000));
    }


    @Test
    @DisplayName("Пополнение счета checkingAccountAccept отрицательный баланс ")
    void checkingAccountAcceptFalse() { // если баланс отрицательный
        assertFalse(checkingAccount.accept(-1500));
    }

    @Test
    @DisplayName("Пополнение счета creditAccount")
    void creditAccount() {
        assertTrue(creditAccount.accept(-1500));
    }


    @Test
    @DisplayName("Пополнение счета creditAccount")
    void creditAccountFalse() {
        assertFalse(creditAccount.accept(1500));
    }

    @Test
    @DisplayName("Пополнение счета savingsAccount")
    void savingAccount() {
        assertTrue(savingsAccount.accept(1500));
    }


    @Test
    @DisplayName("Перевод суммы")
    void testClientFalse() {
        assertFalse(client.accept(1500));
    }
}
