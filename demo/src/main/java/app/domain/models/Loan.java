package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class Loan {

    /** Identificador del prestamo */
    private long loanId;
    /** Tipo de prestamo */
    private LoanType loanType;
    /** ID del cliente solicitante */
    private String requestingClientId;
    /** Monto solicitado */
    private double requestedAmount;
    /** Monto aprobado */
    private double approvedAmount;
    /** Tasa de interes */
    private double interestRate;
    /** Plazo en meses */
    private int termMonths;
    /** Estado del prestamo */
    private LoanStatus loanStatus;
    /** Fecha de aprobacion */
    private Date approvalDate;
    /** Fecha de desembolso */
    private Date disbursementDate;
    /** Cuenta destino del desembolso */
    private String disbursementTargetAccount;
}
