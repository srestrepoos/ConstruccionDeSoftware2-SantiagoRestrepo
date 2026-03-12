package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class OperationsLog {

    /** Identificador del registro */
    private String logId;
    /** Tipo de operacion */
    private String operationType;
    /** Fecha y hora de operacion */
    private Timestamp operationDateTime;
    /** ID del usuario */
    private long userId;
    /** Rol del usuario */
    private String userRole;
    /** ID del producto afectado */
    private String affectedProductId;
    /** Detalles adicionales */
    private LogBook logBook;
}
