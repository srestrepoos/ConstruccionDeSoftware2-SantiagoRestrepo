package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LogBook {

    /** Tipo de entidad */
    private String entityType;
    /** ID de la entidad */
    private String entityId;
    /** Valor anterior */
    private String previousValue;
    /** Valor nuevo */
    private String newValue;
    /** Descripción */
    private String description;
}
