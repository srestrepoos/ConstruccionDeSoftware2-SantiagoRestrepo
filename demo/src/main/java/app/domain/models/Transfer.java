package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class Transfer {

    private long transferId;
    private BankAccount sourceAccount;
    private BankAccount targetAccount;
    private BigDecimal amount;
    private LocalDateTime creationDate;
    private LocalDateTime approvalDate;
    private TransferStatus transferStatus;
    private long creatorUserId;
    private Long approverUserId;

    public void execute() {
        if (this.transferStatus == TransferStatus.APPROVED && this.sourceAccount != null && this.targetAccount != null) {
            this.sourceAccount.withdraw(this.amount);
            this.targetAccount.deposit(this.amount);
            this.transferStatus = TransferStatus.EXECUTED;
        }
    }
}
