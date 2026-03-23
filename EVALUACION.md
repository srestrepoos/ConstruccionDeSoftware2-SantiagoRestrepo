# EVALUACIÓN - ConstruccionDeSoftware2-SantiagoRestrepo

## Información General
- **Estudiante:** Santiago Restrepo
- **Rama evaluada:** develop
- **Fecha de evaluación:** 2026-03-23

---

## Tabla de Calificación

| # | Criterio | Peso | Puntaje (1–5) | Nota ponderada |
|---|---|---|---|---|
| 1 | Modelado de dominio | 25% | 3 | 0.75 |
| 2 | Relaciones entre entidades | 15% | 3 | 0.45 |
| 3 | Uso de Enums | 15% | 4 | 0.60 |
| 4 | Manejo de estados | 5% | 4 | 0.20 |
| 5 | Tipos de datos | 5% | 2 | 0.10 |
| 6 | Separación Usuario vs Cliente | 10% | 5 | 0.50 |
| 7 | Bitácora | 5% | 2 | 0.10 |
| 8 | Reglas básicas de negocio | 5% | 2 | 0.10 |
| 9 | Estructura del proyecto | 10% | 3 | 0.30 |
| 10 | Repositorio | 10% | 2 | 0.20 |
| **TOTAL** | | **100%** | | **3.30 / 5 (base)** |

> Nota base = (3/5×0.25 + 3/5×0.15 + 4/5×0.15 + 4/5×0.05 + 2/5×0.05 + 5/5×0.10 + 2/5×0.05 + 2/5×0.05 + 3/5×0.10 + 2/5×0.10) × 5 = 0.66 × 5 = **3.30**

---

## Penalizaciones

Ninguna penalización aplicable.

---

## Bonus

| Bonus | Puntos |
|---|---|
| Nombres claros y consistentes en inglés (convención camelCase y PascalCase seguida) | +1 |

---

## Nota Final: **4.3 / 5.0**

---

## Análisis por Criterio

### 1. Modelado de dominio — 3/5
Entidades presentes: `Person` (base), `Client` (extiende `Person`, con `birthDate`), `CorporateClient` (extiende `Client`), `User` (extiende `Person`), `BankAccount`, `Loan`, `Transfer`, `GeneralBankProduct`, `OperationsLog` (bitácora), `DetailData`.  
**Problema de jerarquía:** `CorporateClient` extiende `Client`, pero `Client` es la clase de persona natural (tiene `birthDate: Date`). Esto es incorrecto: la empresa estaría heredando `fechaNacimiento` de la persona natural. La jerarquía correcta sería `Client` (abstracta) → `PersonClient` y `CorporateClient`. Este es el error más importante de modelado.

### 2. Relaciones entre entidades — 3/5
`Client` tiene `ArrayList<BankAccount> bankAccounts` ✓ — buena relación uno a muchos.  
`BankAccount` usa `holderId: String` en lugar de `Client client` — relación por ID.  
`Loan` usa `requestingClientId: String` — relación por ID.  
`Transfer` usa `sourceAccount: String` y `targetAccount: String` en lugar de `BankAccount sourceAccount`.  
Mitad de las relaciones usan referencias directas y la otra mitad usan IDs textuales.

### 3. Uso de Enums — 4/5
Enums implementados: `AccountType`, `AccountStatus`, `Currency`, `LoanType`, `LoanStatus`, `TransferStatus`, `SystemRole`, `UserStatus`, `Category`, `ClientRole` ✓  
**Excepción:** `OperationsLog.userRole` es `String` — debería usar el enum `SystemRole`. Este es el único caso de String donde debería ir un enum.

### 4. Manejo de estados — 4/5
`BankAccount` usa `AccountStatus` ✓. `Loan` usa `LoanStatus` ✓. `Transfer` usa `TransferStatus` ✓. `User` usa `UserStatus` ✓. No hay métodos de transición de estado, solo asignación de atributos.

### 5. Tipos de datos — 2/5
`double` para todos los montos monetarios (debería ser `BigDecimal`). Fechas con `java.sql.Date` (en lugar de `java.time.LocalDate`) y `java.sql.Timestamp` (en lugar de `java.time.LocalDateTime`). Estas son las APIs de JDBC, no las del paquete `java.time` recomendado.

### 6. Separación Usuario vs Cliente — 5/5
`User extends Person` y `Client extends Person` son clases completamente independientes. El `User` tiene `username: String`, `systemRole: SystemRole` y `userStatus: UserStatus` — responsabilidades claramente diferenciadas del cliente. Separación excelente.

### 7. Bitácora — 2/5
`OperationsLog` tiene una estructura rígida con `DetailData` (campos fijos: `entityType`, `entityId`, `previousValue`, `newValue`, `description`). No es una estructura flexible `Map<String, Object>` o JSON. Solo cumple parcialmente el criterio de bitácora flexible.

### 8. Reglas básicas de negocio — 2/5
No se encontraron métodos de negocio en ninguna entidad del dominio (sin `depositar`, `retirar`, `aprobar`, `ejecutar`). Las clases son puramente estructuras de datos (Anemic Domain Model).

### 9. Estructura del proyecto — 3/5
Solo se encontró el paquete `domain/models` y `domain/exceptions` en el proyecto evaluable. No hay paquetes de servicios, puertos o capas adicionales en esta rama. La organización básica existe pero es incompleta.

### 10. Repositorio — 2/5
- **Nombre:** `ConstruccionDeSoftware2-SantiagoRestrepo` ✓ formato correcto.
- **Commits:** 3 commits en total (1 en `main`, 2 en `develop`). Muy pocas iteraciones. Mensajes: "Initial commit", "Class creation and documentation", "Entrega Clases" — sin convención ADD/CHG.
- **README:** Solo contiene el título del repositorio.
- **Ramas:** Tiene `develop` ✓.
- **Tag de entrega:** No existe.

---

## Fortalezas
- Buen uso de enums para la mayoría de catálogos y estados del dominio.
- Separación clara entre `User` y `Client` como jerarquías independientes.
- `Client` tiene `ArrayList<BankAccount>` — buena modelación de la relación.
- Proyecto bien nombrado con convención correcta.
- Código en inglés con nombres claros.

## Oportunidades de mejora
- **Crítico:** Corregir la jerarquía de cliente. `CorporateClient` no debe extender `Client` (persona natural). Crear clase abstracta `Client` con subtipos `PersonClient` y `CorporateClient`.
- Agregar métodos de negocio en las entidades: `depositar`, `retirar`, `aprobar/rechazar`, `ejecutar transferencia`.
- Cambiar `OperationsLog.userRole: String` al enum `SystemRole`.
- Reemplazar IDs de texto por referencias a objetos en `BankAccount`, `Loan` y `Transfer`.
- Cambiar `double` a `BigDecimal` para montos y migrar a `java.time` para fechas.
- Implementar `OperationsLog` con estructura flexible `Map<String, Object>`.
- Aumentar número de commits con mensajes descriptivos y convención ADD/CHG.
- Completar el README con información del équipo, tecnología y pasos de ejecución.
- Agregar tag de entrega.
