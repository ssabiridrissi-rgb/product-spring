package ma.mundia.studentsapp.web;

import ma.mundia.studentsapp.entities.Product;
import ma.mundia.studentsapp.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestService {

    private final ProductRepository productRepository;

    // Injection via constructeur (bonne pratique)
    public ProductRestService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ------------------------
    // Liste de tous les produits
    // ------------------------
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ------------------------
    // Chercher un produit par ID
    // ------------------------
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
