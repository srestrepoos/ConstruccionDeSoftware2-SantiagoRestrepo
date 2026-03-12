package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class BankAccount {

    /** Numero de cuenta */
    private String accountNumber;
    /** Tipo de cuenta */
    private AccountType accountType;
    /** ID del titular */
    private String holderId;
    /** Saldo actual */
    private double currentBalance;
    /** Moneda */
    private Currency currency;
    /** Estado de la cuenta */
    private AccountStatus accountStatus;
    /** Fecha de apertura */
    private Date openingDate;
}
