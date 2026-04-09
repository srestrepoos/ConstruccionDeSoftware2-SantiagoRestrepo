package app.application.adapters.persistence.sql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccountEntity {

    @Id
    private Long id;

    // Campos adicionales para la base de datos
}
