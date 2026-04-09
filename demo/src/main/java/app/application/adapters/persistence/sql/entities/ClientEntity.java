package app.application.adapters.persistence.sql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    private Long id;

    // Campos adicionales para la base de datos
}
