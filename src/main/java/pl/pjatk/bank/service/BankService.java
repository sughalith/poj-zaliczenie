package pl.pjatk.bank.service;

import lombok.RequiredArgsConstructor;
import pl.pjatk.bank.model.Account;
import pl.pjatk.bank.model.Bank;
import pl.pjatk.bank.model.User;

import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
public class BankService {

    private final Bank bank;

    public BigDecimal accountBalance(User user){
        Optional<Account> accountForUser = getAccountForUser(user);
        if (accountForUser.isPresent()){
            return accountForUser.get().getBalance();
        } else {
            return BigDecimal.ZERO;
        }
    }

    public Optional<Account> getAccountForUser(User user){
        return bank.getAccounts().stream().filter(account -> account.getUser().getId() == user.getId()).findFirst();
    }

    public boolean checkBankAndAccountCorrelation(Account account){
        return account.getAccountNumber().substring(2, 6).equals(bank.getAccountIdentificator());
    }

    public BigDecimal topUpAccount(BigDecimal topUpAmount, User user) {
        Account account = getAccountForUser(user).get();
        account.setBalance(account.getBalance().add(topUpAmount));
        return account.getBalance();
    }

    public BigDecimal transferMoney(User fromUser, User toUser, BigDecimal amount){
        Account fromAccount = getAccountForUser(fromUser).get();
        Account toAccount = getAccountForUser(toUser).get();

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));
        return toAccount.getBalance();


    }

}
