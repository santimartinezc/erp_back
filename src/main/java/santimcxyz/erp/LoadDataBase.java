package santimcxyz.erp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import santimcxyz.erp.Product.Product;
import santimcxyz.erp.Product.ProductRepository;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initData(ProductRepository productRepository) {
        return args -> {

            Product Product1 = new Product((long) 42523243,"Product1",10,(float)21.0, (float) 9.99);
            Product Product2 = new Product((long) 42523243,"Product1",10,(float)21.0, (float) 9.99);
            Product Product3 = new Product((long) 42523243,"Product1",10,(float)21.0, (float) 9.99);
            
            productRepository.save(Product1);
            productRepository.save(Product2);
            productRepository.save(Product3);
            

            log.info("Database initialized with some sample data.");
        };
    }
}
