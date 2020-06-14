package pl.pjatk.bank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String surname;

}
