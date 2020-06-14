package pl.pjatk.bank;

import pl.pjatk.bank.model.Account;
import pl.pjatk.bank.model.Bank;
import pl.pjatk.bank.model.User;
import pl.pjatk.bank.service.BankService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account account = new Account();
        Account account2 = new Account();
        User user = new User();
        User user2 = new User();
        BankService bankService = new BankService(bank);

        user.setId(1);
        user.setName("Arek");

        account.setUser(user);
        account.setAccountNumber("10987612341234123412341234");
        account.setBalance(BigDecimal.valueOf(1000));

        user2.setId(2);
        user2.setName("Arek");

        account2.setUser(user2);
        account2.setAccountNumber("10987612341234123412341234");
        account2.setBalance(BigDecimal.valueOf(1000));

        bank.setName("ING");
        bank.setAccountIdentificator("9876");
        bank.getAccounts().add(account);
        bank.getAccounts().add(account2);
        bankService.checkBankAndAccountCorrelation(account);
        bankService.topUpAccount(BigDecimal.valueOf(100), user);

        System.out.println("Account balance: " + bankService.accountBalance(user));

        System.out.println(bankService.transferMoney(user, user2, BigDecimal.valueOf(500)));

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Account>> violations = validator.validate(account);
        System.out.println("Violations: " + violations);
    }
}
