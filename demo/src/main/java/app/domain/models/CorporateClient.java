package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CorporateClient extends Client {

    /** Razon social */
    private String businessName;
    /** NIT */
    private String nit;
    /** Representante legal */
    private String legalRepresentative;
    /** Nombre de usuario */
    private String username;
}
