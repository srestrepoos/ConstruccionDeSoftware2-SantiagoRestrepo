package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class Loan {

    private long loanId;
    private LoanType loanType;
    private Client requestingClient;
    private BigDecimal requestedAmount;
    private BigDecimal approvedAmount;
    private BigDecimal interestRate;
    private int termMonths;
    private LoanStatus loanStatus;
    private LocalDate approvalDate;
    private LocalDate disbursementDate;
    private String disbursementTargetAccount;

    public void approve() {
        this.loanStatus = LoanStatus.APPROVED;
        this.approvalDate = LocalDate.now();
    }

    public void reject() {
        this.loanStatus = LoanStatus.REJECTED;
    }
}
