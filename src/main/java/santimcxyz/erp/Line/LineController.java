package santimcxyz.erp.Line;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import santimcxyz.erp.Product.Product;
import santimcxyz.erp.Product.ProductRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/lines")
public class LineController {
    @Autowired
    private LineRepository lineRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Line> getAllLines(HttpServletRequest request) {
        return lineRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Line> getLine(@PathVariable Long id, HttpServletRequest request) {
        Optional<Line> lineOptional = lineRepository.findById(id);

        if (lineOptional.isPresent()) {
            return new ResponseEntity<>(lineOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<List<Line>> getLinesFromTransaction(@PathVariable Long transactionId,
            HttpServletRequest request) {
        List<Line> lineList = lineRepository.findByTransactionId(transactionId);

        if (!lineList.isEmpty()) {
            return new ResponseEntity<>(lineList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Line> createLine(@Valid @RequestBody Line line,
            HttpServletRequest request) {
        Line savedLine = lineRepository.save(line);

        Product product = productRepository.findById(line.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        product.setQuantity(product.getQuantity() - line.getQuantity());
        productRepository.save(product);

        return new ResponseEntity<>(savedLine, HttpStatus.CREATED);
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Line>> createLines(@Valid @RequestBody List<Line> lines,
            HttpServletRequest request) {
        List<Line> savedLines = new ArrayList<>();
        for (Line line : lines) {
            Product product = productRepository.findById(line.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            product.setQuantity(product.getQuantity() - line.getQuantity());
            productRepository.save(product);
            lineRepository.save(line);
        }
        return new ResponseEntity<>(savedLines, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Line> updateLine(@PathVariable Long id,
            @RequestBody Line updatedLine, HttpServletRequest request) {
        Optional<Line> existingLine = lineRepository.findById(id);

        if (existingLine.isPresent()) {
            Line line = existingLine.get();

            line.setTransactionId(updatedLine.getTransactionId());
            line.setProductName(updatedLine.getProductName());
            line.setQuantity(updatedLine.getQuantity());
            line.setTaxes_pctg(updatedLine.getTaxes_pctg());
            line.setPrice(updatedLine.getPrice());

            Line savedLine = lineRepository.save(line);
            return new ResponseEntity<>(savedLine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLine(@PathVariable Long id, HttpServletRequest request) {
        Optional<Line> lineOptional = lineRepository.findById(id);

        if (lineOptional.isPresent()) {
            lineRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
