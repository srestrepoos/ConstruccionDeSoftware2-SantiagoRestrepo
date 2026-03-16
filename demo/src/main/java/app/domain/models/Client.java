package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Client extends Person {
    private Date birthDate;
    private ArrayList<BankAccount> bankAccounts;
}
