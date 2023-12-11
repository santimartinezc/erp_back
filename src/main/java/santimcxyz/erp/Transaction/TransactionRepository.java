//TransactionRepository
package santimcxyz.erp.Transaction;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByCreatedAtBetweenOrderByCreatedAtDesc(
            LocalDateTime createdAtStart,
            LocalDateTime createdAtEnd);

    // Facturación diaria sin filtros
    @Query("SELECT SUM(t.totalAmount) as total, CAST(t.createdAt AS DATE) as fecha FROM Transaction t GROUP BY CAST(t.createdAt AS DATE)")
    List<Object[]> findAllFacturadoPorDia();

    // Facturación diaria hasta ese día
    @Query("SELECT SUM(t.totalAmount) as total, CAST(t.createdAt AS DATE) as fecha FROM Transaction t WHERE CAST(t.createdAt AS DATE) <= :creationDateTime GROUP BY CAST(t.createdAt AS DATE)")
    List<Object[]> findFacturadoPorDia(@Param("creationDateTime") Date creationDateTime);

    // Facturación diaria para periodo entre fechas
    @Query("SELECT new santimcxyz.erp.Transaction.TransactionPeriodDTO(CAST(t.createdAt AS DATE) as fecha, SUM(t.totalAmount) as total) FROM Transaction t WHERE CAST(t.createdAt AS DATE) BETWEEN :startDate AND :endDate GROUP BY CAST(t.createdAt AS DATE)")
    List<TransactionPeriodDTO> facturacionEnPeriodo(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT new santimcxyz.erp.Transaction.TransactionPeriodDTO(MONTH(t.createdAt) as mes, YEAR(t.createdAt) as ano, SUM(t.totalAmount) as total) FROM Transaction t WHERE t.createdAt BETWEEN :startDate AND :endDate GROUP BY MONTH(t.createdAt), YEAR(t.createdAt)")
    List<TransactionPeriodDTO> facturacionMensualEnPeriodo(@Param("startDate") Date startDate,
            @Param("endDate") Date endDate);

}