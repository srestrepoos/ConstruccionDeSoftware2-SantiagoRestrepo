# EVALUACION 2 - ConstruccionDeSoftware2-SantiagoRestrepo

## Informacion general
- Estudiante(s): Santiago Restrepo
- Rama evaluada: develop
- Commit evaluado: 4d142e4e (origin/develop, commit mas reciente del estudiante tras revisar todas las ramas)
- Fecha: 2026-04-11

---

## Tabla de calificacion

| Criterio | Peso | Puntaje (1-5) | Parcial |
|---|---|---|---|
| 1. Modelado de dominio | 20% | 3 | 0.60 |
| 2. Modelado de puertos | 20% | 1 | 0.20 |
| 3. Modelado de servicios de dominio | 20% | 1 | 0.20 |
| 4. Enums y estados | 10% | 3 | 0.30 |
| 5. Reglas de negocio criticas | 10% | 1 | 0.10 |
| 6. Bitacora y trazabilidad | 5% | 2 | 0.10 |
| 7. Estructura interna de dominio | 10% | 2 | 0.20 |
| 8. Calidad tecnica base en domain | 5% | 3 | 0.15 |
| **SUBTOTAL** | 100% | | **1.85** |

### Calculo
Nota base = Î£((puntaje_i / 5) * peso_i) / 20 = 37 / 20 = **1.85**

### Penalizaciones aplicadas
| Penalizacion | Motivo | Reduccion |
|---|---|---|
| Estados en String | OperationsLog.userRole es String en lugar de enum SystemRole | -10% |

Nota tras penalizacion: 1.85 Ã— 0.90 = **1.67**

---

## Nota final
**2.6 / 5.0**

---

## Hallazgos

### Positivos
- **Entidades completas y bien definidas:** AccountStatus, AccountType, BankAccount, Client, CorporateClient, Currency, GeneralBankProduct, Loan, OperationsLog, Person, SystemRole, Transfer, User con jerarquias coherentes.
- **Enums correctos en su mayoria:** AccountStatus, AccountType, Currency, LoanStatus, LoanType, SystemRole, TransferStatus, UserStatus todos como enum.
- **TransferStatus con el flujo completo:** PENDING, AWAITING_APPROVAL, APPROVED, EXECUTED, REJECTED, EXPIRED.
- **LoanStatus con estados completos:** UNDER_REVIEW, APPROVED, REJECTED, DISBURSED, OVERDUE, CANCELLED.
- **DetailData** para datos de auditoria variables.
- **BusinessException** para excepciones del dominio.
- **Nomenclatura en ingles clara y consistente.**

### Negativos
- **Sin puertos de dominio:** No existe ninguna interfaz de puerto. La arquitectura hexagonal no esta implementada. No hay contrato de salida para ningun agregado.
- **Sin servicios de dominio:** No hay ninguna clase de servicio de dominio. Las reglas de negocio no estan implementadas.
- **Modelos anemicos:** Las entidades no tienen metodos de negocio (depositar, retirar, aprobar, ejecutar). Son solo contenedores de datos con getters/setters.
- **BankAccount.holderId como String:** Referencia al cliente por ID textual en lugar de entidad `Client`. La relacion queda rota.
- **Loan.disbursementTargetAccount como String:** Referencia a cuenta destino por ID textual en lugar de entidad `BankAccount`.
- **Transfer.sourceAccount y targetAccount como Strings:** Misma falla; las cuentas deberian ser entidades, no solo strings.
- **OperationsLog.userRole como String:** No usa el enum SystemRole ya definido. Inconsistencia.
- **Client tiene birthDate:** `birthDate` es de personas naturales, no de CorporateClient. La jerarquia mezcla atributos; falta diferenciar NaturalPersonClient de CorporateClient en la jerarquia.
- **ClientRole confuso:** Valores `Client` y `CorporateClient` no representan roles sino tipos de cliente. Nomenclatura inadecuada.

---

## Recomendaciones
1. Crear interfaces de puerto por agregado: ClientPort, BankAccountPort, LoanPort, TransferPort, BinnaclePort, UserPort.
2. Implementar servicios de dominio: CreateAccount (validar numero unico, cliente existe), CreateTransfer (validar saldo, cuenta activa), CreateLoan, ApproveLoan.
3. Agregar logica de negocio a las entidades: BankAccount.withdraw() que valide estado ACTIVE y saldo suficiente; Loan.approve(), Loan.reject(), Loan.disburse().
4. Cambiar `holderId: String` en BankAccount por referencia directa a `Client cliente`.
5. Cambiar `disbursementTargetAccount: String` en Loan y las cuentas en Transfer a referencias de entidades reales.
6. Corregir `OperationsLog.userRole` de String a `SystemRole`.
7. Separar NaturalPersonClient y CorporateClient en jerarquia explicita y eliminar `birthDate` de la clase base Client.
8. Renombrar ClientRole a ClientType con valores NATURAL_PERSON y CORPORATE.


