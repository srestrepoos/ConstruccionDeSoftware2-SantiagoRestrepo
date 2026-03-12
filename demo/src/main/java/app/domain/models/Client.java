package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class Client {

    /** Identificador del cliente */
    private long id;
    /** Nombre */
    private String name;
    /** Documento */
    private String document;
    /** Telefono */
    private String phone;
    /** Correo electronico */
    private String email;
    /** Direccion */
    private String address;
    /** Fecha de nacimiento */
    private Date birthDate;
    /** Estado del cliente */
    private ClientStatus clientStatus;
}
