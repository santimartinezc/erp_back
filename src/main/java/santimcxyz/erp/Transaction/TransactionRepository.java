//TransactionRepository
package santimcxyz.erp.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByCreatedAtBetween(
            LocalDateTime createdAtStart,
            LocalDateTime createdAtEnd);
}
