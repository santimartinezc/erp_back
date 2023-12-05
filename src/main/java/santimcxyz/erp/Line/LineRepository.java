package santimcxyz.erp.Line;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineRepository extends JpaRepository<Line, Long> {
    List<Line> findByTransactionId(Long transactionId);

}
