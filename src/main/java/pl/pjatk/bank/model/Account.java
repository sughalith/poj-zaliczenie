package pl.pjatk.bank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pjatk.bank.validator.AccountNumber;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Account {

    private User user;
    private BigDecimal balance;
    @AccountNumber
    private String accountNumber;
}
