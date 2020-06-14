package pl.pjatk.bank.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {
    private String name;
    private String accountIdentificator;
    private List<Account> accounts;

    public Bank(){
        this.accounts = new ArrayList<>();
    }
}
