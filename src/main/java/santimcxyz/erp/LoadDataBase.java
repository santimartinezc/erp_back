package santimcxyz.erp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
            productRepository.save(new Product(34L, "Pan Integral", 100, 10.0f, 3.50f));
            productRepository.save(new Product(35L, "Leche Desnatada", 200, 5.0f, 1.20f));
            productRepository.save(new Product(36L, "Cereal de Maíz", 150, 8.0f, 2.50f));
            productRepository.save(new Product(37L, "Jugo de Naranja", 120, 6.0f, 2.00f));
            productRepository.save(new Product(38L, "Pasta de Dientes", 80, 7.0f, 4.50f));
            productRepository.save(new Product(39L, "Jabón de Manos", 150, 5.0f, 1.75f));
            productRepository.save(new Product(40L, "Galletas de Avena", 100, 10.0f, 3.00f));
            productRepository.save(new Product(41L, "Arroz Blanco", 200, 5.0f, 1.20f));
            productRepository.save(new Product(42L, "Aceite de Oliva", 50, 15.0f, 5.50f));
            productRepository.save(new Product(43L, "Atún en Lata", 180, 8.0f, 2.30f));
            productRepository.save(new Product(44L, "Café Molido", 90, 20.0f, 6.00f));
            productRepository.save(new Product(45L, "Yogur Natural", 200, 5.0f, 0.80f));
            productRepository.save(new Product(46L, "Mantequilla", 75, 7.0f, 2.50f));
            productRepository.save(new Product(47L, "Queso Cheddar", 60, 12.0f, 4.00f));
            productRepository.save(new Product(48L, "Huevos", 180, 5.0f, 3.20f));
            productRepository.save(new Product(49L, "Chocolate Negro", 110, 8.0f, 2.10f));
            productRepository.save(new Product(50L, "Harina de Trigo", 130, 5.0f, 1.00f));
            productRepository.save(new Product(51L, "Azúcar Blanca", 200, 5.0f, 1.50f));
            productRepository.save(new Product(52L, "Sal Marina", 150, 5.0f, 0.90f));
            productRepository.save(new Product(53L, "Pimienta Negra", 70, 10.0f, 3.00f));
            productRepository.save(new Product(54L, "Vinagre Balsámico", 80, 12.0f, 4.25f));
            productRepository.save(new Product(55L, "Salsa de Tomate", 120, 8.0f, 2.20f));
            productRepository.save(new Product(56L, "Mostaza", 90, 6.0f, 1.80f));
            productRepository.save(new Product(57L, "Mayonesa", 85, 7.0f, 2.00f));
            productRepository.save(new Product(58L, "Pan de Molde", 100, 7.0f, 2.30f));
            productRepository.save(new Product(59L, "Jamón Cocido", 120, 5.0f, 3.50f));
            productRepository.save(new Product(60L, "Peperoni", 70, 15.0f, 4.00f));
            productRepository.save(new Product(61L, "Salmón Ahumado", 60, 12.0f, 5.50f));
            productRepository.save(new Product(62L, "Camarones", 50, 10.0f, 6.00f));
            productRepository.save(new Product(63L, "Espárragos", 100, 5.0f, 2.80f));
            productRepository.save(new Product(64L, "Lechuga Romana", 150, 5.0f, 1.00f));
            productRepository.save(new Product(65L, "Tomates Cherry", 120, 8.0f, 2.50f));
            productRepository.save(new Product(66L, "Papas", 200, 5.0f, 1.20f));
            productRepository.save(new Product(67L, "Zanahorias", 150, 5.0f, 1.00f));
            productRepository.save(new Product(68L, "Manzanas Rojas", 180, 5.0f, 2.00f));
            productRepository.save(new Product(69L, "Naranjas", 170, 5.0f, 2.10f));
            productRepository.save(new Product(70L, "Plátanos", 160, 5.0f, 1.80f));
            productRepository.save(new Product(71L, "Uvas", 90, 8.0f, 2.70f));
            productRepository.save(new Product(72L, "Fresas", 80, 10.0f, 3.00f));
            productRepository.save(new Product(73L, "Kiwi", 70, 8.0f, 2.30f));
            productRepository.save(new Product(74L, "Aguacates", 60, 12.0f, 1.50f));
            productRepository.save(new Product(75L, "Limones", 140, 5.0f, 0.70f));
            productRepository.save(new Product(76L, "Cebollas", 130, 5.0f, 1.00f));
            productRepository.save(new Product(77L, "Ajos", 110, 5.0f, 0.50f));
            productRepository.save(new Product(78L, "Calabacines", 100, 5.0f, 1.40f));
            productRepository.save(new Product(79L, "Berenjenas", 90, 8.0f, 1.60f));
            productRepository.save(new Product(80L, "Pimientos Rojos", 85, 7.0f, 1.80f));
            productRepository.save(new Product(81L, "Brócoli", 75, 10.0f, 2.20f));
            productRepository.save(new Product(82L, "Espinacas", 120, 5.0f, 1.00f));
            productRepository.save(new Product(83L, "Champiñones", 100, 8.0f, 2.50f));
            lineRepository.save(new Line(1L, 1L, "Pan Integral", 10, 10.0f, 3.50f));
            lineRepository.save(new Line(2L, 1L, "Leche Desnatada", 20, 5.0f, 1.20f));
            lineRepository.save(new Line(3L, 2L, "Cereal de Maíz", 15, 8.0f, 2.50f));
            lineRepository.save(new Line(4L, 2L, "Jugo de Naranja", 25, 6.0f, 2.00f));
            lineRepository.save(new Line(5L, 3L, "Pasta de Dientes", 30, 7.0f, 4.50f));
            lineRepository.save(new Line(6L, 3L, "Jabón de Manos", 35, 5.0f, 1.75f));
            lineRepository.save(new Line(7L, 3L, "Galletas de Avena", 40, 10.0f, 3.00f));
            lineRepository.save(new Line(8L, 4L, "Arroz Blanco", 45, 5.0f, 1.20f));
            lineRepository.save(new Line(9L, 4L, "Aceite de Oliva", 50, 15.0f, 5.50f));
            lineRepository.save(new Line(10L, 5L, "Atún en Lata", 55, 8.0f, 2.30f));
            lineRepository.save(new Line(11L, 6L, "Café Molido", 60, 20.0f, 6.00f));
            lineRepository.save(new Line(12L, 6L, "Yogur Natural", 65, 5.0f, 0.80f));
            lineRepository.save(new Line(13L, 6L, "Mantequilla", 70, 7.0f, 2.50f));
            lineRepository.save(new Line(14L, 7L, "Queso Cheddar", 75, 12.0f, 4.00f));
            lineRepository.save(new Line(15L, 7L, "Huevos", 80, 5.0f, 3.20f));
            lineRepository.save(new Line(16L, 7L, "Chocolate Negro", 85, 8.0f, 2.10f));
            lineRepository.save(new Line(17L, 8L, "Harina de Trigo", 90, 5.0f, 1.00f));
            lineRepository.save(new Line(18L, 8L, "Azúcar Blanca", 95, 5.0f, 1.50f));
            lineRepository.save(new Line(19L, 9L, "Sal Marina", 100, 5.0f, 0.90f));
            lineRepository.save(new Line(20L, 10L, "Pimienta Negra", 105, 10.0f, 3.00f));
            lineRepository.save(new Line(21L, 10L, "Vinagre Balsámico", 110, 12.0f, 4.25f));
            lineRepository.save(new Line(22L, 10L, "Salsa de Tomate", 115, 8.0f, 2.20f));
            lineRepository.save(new Line(23L, 10L, "Mostaza", 120, 6.0f, 1.80f));
            lineRepository.save(new Line(24L, 11L, "Mayonesa", 125, 7.0f, 2.00f));
            lineRepository.save(new Line(25L, 12L, "Pan de Molde", 130, 7.0f, 2.30f));
            lineRepository.save(new Line(26L, 13L, "Jamón Cocido", 135, 5.0f, 3.50f));
            lineRepository.save(new Line(27L, 14L, "Peperoni", 140, 15.0f, 4.00f));
            lineRepository.save(new Line(28L, 14L, "Salmón Ahumado", 145, 12.0f, 5.50f));
            lineRepository.save(new Line(29L, 15L, "Camarones", 150, 10.0f, 6.00f));
            lineRepository.save(new Line(30L, 15L, "Espárragos", 155, 5.0f, 2.80f));
            transactionRepository.save(new Transaction(1001L, 450.30f));
            transactionRepository.save(new Transaction(1002L, 220.75f));
            transactionRepository.save(new Transaction(1003L, 330.50f));
            transactionRepository.save(new Transaction(1004L, 560.00f));
            transactionRepository.save(new Transaction(1005L, 275.15f));
            transactionRepository.save(new Transaction(1006L, 485.90f));
            transactionRepository.save(new Transaction(1007L, 320.40f));
            transactionRepository.save(new Transaction(1008L, 150.20f));
            transactionRepository.save(new Transaction(1009L, 410.00f));
            transactionRepository.save(new Transaction(1010L, 505.60f));
            transactionRepository.save(new Transaction(1011L, 260.25f));
            transactionRepository.save(new Transaction(1012L, 390.80f));
            transactionRepository.save(new Transaction(1013L, 180.55f));
            transactionRepository.save(new Transaction(1014L, 470.10f));
            transactionRepository.save(new Transaction(1015L, 305.75f));

            log.info("Database initialized with some sample data.");
        };
    }
}
