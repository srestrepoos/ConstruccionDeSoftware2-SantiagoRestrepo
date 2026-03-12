package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Transfer {

    /** Identificador de la transferencia */
    private long transferId;
    /** Cuenta de origen */
    private String sourceAccount;
    /** Cuenta de destino */
    private String targetAccount;
    /** Monto a transferir */
    private double amount;
    /** Fecha de solicitud */
    private Timestamp creationDate;
    /** Fecha de aprobacion */
    private Timestamp approvalDate;
    /** Estado de la transferencia */
    private TransferStatus transferStatus;
    /** ID del usuario creador */
    private long creatorUserId;
    /** ID del usuario aprobador */
    private Long approverUserId;
}
