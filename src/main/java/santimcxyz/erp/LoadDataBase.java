package santimcxyz.erp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime; //filter
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import santimcxyz.erp.Line.Line;
import santimcxyz.erp.Line.LineRepository;
import santimcxyz.erp.Product.Product;
import santimcxyz.erp.Product.ProductRepository;
import santimcxyz.erp.Transaction.Transaction;
import santimcxyz.erp.Transaction.TransactionRepository;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initData(ProductRepository productRepository, LineRepository lineRepository,
            TransactionRepository transactionRepository) {
        return args -> {
            lineRepository.save(new Line(1L, 1L, "Pan Integral", 10, 10.0f, 3.50f));
            lineRepository.save(new Line(2L, 1L, "Leche Desnatada", 20, 5.0f, 1.20f));

            float amount = 100 + new Random().nextFloat() * 500;
            Transaction t = new Transaction(1L, amount);
            t.setCreatedAt(LocalDate.now().atTime(9, 0));
            t.setCreatedAt(LocalDate.now().atTime(9, 0));
            transactionRepository.save(t);
        };
    }
}
