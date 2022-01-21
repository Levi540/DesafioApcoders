package br.com.apcoders.desafio.domain.repository;

import br.com.apcoders.desafio.domain.entity.UnitExpense;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitExpensesRepository extends JpaRepository<UnitExpense, Long> {
    @Query(
        "SELECT ue FROM UnitExpense ue WHERE " +
        "(:idUnity IS NULL OR ue.idUnity = :idUnity) AND " +
        "(:invoiceDueDate IS NULL OR ue.invoiceDueDate < :invoiceDueDate)"
    )
    List<UnitExpense> findAllWithFilters(@Param("idUnity") Long idUnity, @Param("invoiceDueDate") LocalDate invoiceDueDate);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(
        "UPDATE UnitExpense ue " +
        "SET ue.unitExpenseDescription = :unitExpenseDescription, " +
        "ue.typeExpense = :typeExpense, " +
        "ue.amount = :amount, " +
        "ue.invoiceDueDate = :invoiceDueDate, " +
        "ue.paymentStatus = :paymentStatus, " +
        "ue.idUnity = :idUnity " +
        "WHERE ue.id = :unitExpenseId"
    )
    void updateUnitExpense(
        @Param("unitExpenseId") Long unitExpenseId,
        @Param("unitExpenseDescription") String unitExpenseDescription,
        @Param("typeExpense") String typeExpense,
        @Param("amount") Double amount,
        @Param("invoiceDueDate") LocalDate invoiceDueDate,
        @Param("paymentStatus") String paymentStatus,
        @Param("idUnity") Long idUnity
    );
}
