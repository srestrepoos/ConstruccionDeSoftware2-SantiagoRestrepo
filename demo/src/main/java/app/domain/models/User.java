package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class User {

    /** Identificador del usuario */
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
    /** Nombre de usuario */
    private String username;
    /** Rol en el sistema */
    private SystemRole systemRole;
    /** Estado del usuario */
    private UserStatus userStatus;
}
