package santimcxyz.erp.Transaction;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime; //filter
import java.time.LocalDate;
import java.time.DayOfWeek;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.temporal.TemporalAdjusters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public List<Transaction> getAllTransactions(HttpServletRequest request) {
        return transactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id, HttpServletRequest request) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);

        if (transactionOptional.isPresent()) {
            return new ResponseEntity<>(transactionOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filter") // Devuelve una lista de las transacciones diarias entre dos fechas
    public List<Transaction> getTransactionsBetweenDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createdAtStart,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createdAtEnd) {
        return transactionRepository.findAllByCreatedAtBetweenOrderByCreatedAtDesc(createdAtStart,
                createdAtEnd.plusDays(1));
    }

    @GetMapping("/day") // Devulve una lista de facuraciones diarias
    public List<Object[]> getAmountsByDay() {
        return transactionRepository.findAllFacturadoPorDia();
    }

    @GetMapping("/day2") // Devuelve una lista de facturaciones diarias previas a la fecha que se pasa
                         // por parámetro
    public List<Object[]> getAmountOfDay2(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime day) {
        Date sqlDate = Date.valueOf(day.toLocalDate());
        return transactionRepository.findFacturadoPorDia(sqlDate);
    }

    @GetMapping("/betweenDates")
    public List<TransactionPeriodDTO> getAmountOfDayBetweenDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime end) {
        LocalDate startlocalDate = start.toLocalDate();
        LocalDate endlocalDate = end.toLocalDate();
        java.sql.Date startDate = java.sql.Date.valueOf(startlocalDate);
        java.sql.Date endDate = java.sql.Date.valueOf(endlocalDate);
        // Llamada al repositorio con java.sql.Date
        return transactionRepository.facturacionEnPeriodo(startDate, endDate);
    }

    @GetMapping("/week")
    public List<TransactionPeriodDTO> getAmountOfDayByWeek(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime day) {
        // Convierte LocalDateTime a LocalDate para trabajar solo con fechas
        LocalDate localDate = day.toLocalDate();
        // Encuentra el inicio de la semana (lunes)
        LocalDate startOfWeek = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        // Encuentra el fin de la semana (domingo)
        LocalDate endOfWeek = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        // Convierte LocalDate a java.sql.Date para la llamada al repositorio
        java.sql.Date startDate = java.sql.Date.valueOf(startOfWeek);
        java.sql.Date endDate = java.sql.Date.valueOf(endOfWeek);
        // Llamada al repositorio con java.sql.Date
        return transactionRepository.facturacionEnPeriodo(startDate, endDate);
    }

    @GetMapping("/month")
    public List<TransactionPeriodDTO> getAmountOfDayByMonth(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime day) {
        // Convierte LocalDateTime a LocalDate para trabajar solo con fechas
        LocalDate localDate = day.toLocalDate();
        // Encuentra el inicio del mes
        LocalDate startOfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
        // Encuentra el fin del mes
        LocalDate endOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        // Convierte LocalDate a java.sql.Date para la llamada al repositorio
        java.sql.Date startDate = java.sql.Date.valueOf(startOfMonth);
        java.sql.Date endDate = java.sql.Date.valueOf(endOfMonth);
        // Llamada al repositorio con java.sql.Date
        return transactionRepository.facturacionEnPeriodo(startDate, endDate);
    }

    @GetMapping("/year")
    public List<TransactionPeriodDTO> getAmountOfMonthByYear(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime day) {
        // Convierte LocalDateTime a LocalDate para trabajar solo con fechas
        LocalDate localDate = day.toLocalDate();
        // Encuentra el inicio del año
        LocalDate startOfYear = localDate.with(TemporalAdjusters.firstDayOfYear());
        // Encuentra el fin del año
        LocalDate endOfYear = localDate.with(TemporalAdjusters.lastDayOfYear());
        // Convierte LocalDate a java.sql.Date para la llamada al repositorio
        java.sql.Date startDate = java.sql.Date.valueOf(startOfYear);
        java.sql.Date endDate = java.sql.Date.valueOf(endOfYear);
        // Llamada al repositorio con java.sql.Date
        return transactionRepository.facturacionMensualEnPeriodo(startDate, endDate);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction,
            HttpServletRequest request) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id,
            @RequestBody Transaction updatedTransaction, HttpServletRequest request) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);

        if (existingTransaction.isPresent()) {
            Transaction transaction = existingTransaction.get();
            transaction.setTotalAmount(updatedTransaction.getTotalAmount());
            transaction.setVendorId(updatedTransaction.getVendorId());
            Transaction savedTransaction = transactionRepository.save(transaction);
            return new ResponseEntity<>(savedTransaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id, HttpServletRequest request) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);

        if (transactionOptional.isPresent()) {
            transactionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
