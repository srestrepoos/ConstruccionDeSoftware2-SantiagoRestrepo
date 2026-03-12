package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GeneralBankProduct {

    /** Codigo del producto */
    private String productCode;
    /** Nombre del producto */
    private String productName;
    /** Categoria */
    private String category;
    /** Requiere aprobacion */
    private boolean requiresApproval;
}
