package br.com.apcoders.desafio.domain.entity;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "unit_expenses")
public class UnitExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_expense_description", nullable = false)
    private String unitExpenseDescription;

    @Column(name = "type_expense", nullable = false)
    private String typeExpense;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "invoice_due_date", nullable = false)
    private LocalDate invoiceDueDate;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    @Column(name = "id_unity", nullable = false)
    private Long idUnity;

    public UnitExpense() {}

    private UnitExpense(
        Long id,
        String unitExpenseDescription,
        String typeExpense,
        Double amount,
        LocalDate invoiceDueDate,
        String paymentStatus,
        Long idUnity
    ) {
        this.id = id;
        this.unitExpenseDescription = unitExpenseDescription;
        this.typeExpense = typeExpense;
        this.amount = amount;
        this.invoiceDueDate = invoiceDueDate;
        this.paymentStatus = paymentStatus;
        this.idUnity = idUnity;
    }

    public Long getId() {
        return id;
    }

    public String getUnitExpenseDescription() {
        return unitExpenseDescription;
    }

    public String getTypeExpense() {
        return typeExpense;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public Long getIdUnity() {
        return idUnity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitExpense that = (UnitExpense) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(unitExpenseDescription, that.unitExpenseDescription) &&
            Objects.equals(typeExpense, that.typeExpense) &&
            Objects.equals(amount, that.amount) &&
            Objects.equals(invoiceDueDate, that.invoiceDueDate) &&
            Objects.equals(paymentStatus, that.paymentStatus) &&
            Objects.equals(idUnity, that.idUnity)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unitExpenseDescription, typeExpense, amount, invoiceDueDate, paymentStatus, idUnity);
    }

    @Override
    public String toString() {
        return (
            "UnitExpense{" +
            "id=" +
            id +
            ", unitExpenseDescription='" +
            unitExpenseDescription +
            '\'' +
            ", typeExpense='" +
            typeExpense +
            '\'' +
            ", amount=" +
            amount +
            ", invoiceDueDate=" +
            invoiceDueDate +
            ", paymentStatus='" +
            paymentStatus +
            '\'' +
            ", idUnity=" +
            idUnity +
            '}'
        );
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String unitExpenseDescription;
        private String typeExpense;
        private Double amount;
        private LocalDate invoiceDueDate;
        private String paymentStatus;
        private Long idUnity;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder unitExpenseDescription(String unitExpenseDescription) {
            this.unitExpenseDescription = unitExpenseDescription;
            return this;
        }

        public Builder typeExpense(String typeExpense) {
            this.typeExpense = typeExpense;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder invoiceDueDate(LocalDate invoiceDueDate) {
            this.invoiceDueDate = invoiceDueDate;
            return this;
        }

        public Builder paymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder idUnity(Long idUnity) {
            this.idUnity = idUnity;
            return this;
        }

        public UnitExpense build() {
            return new UnitExpense(id, unitExpenseDescription, typeExpense, amount, invoiceDueDate, paymentStatus, idUnity);
        }
    }
}
