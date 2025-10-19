package ma.mundia.studentsapp;

import ma.mundia.studentsapp.entities.Product;
import ma.mundia.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
   @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(StudentsAppApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"Computer",4300,3));
        //productRepository.save(new Product(null,"Pinter",1200,4));
        //productRepository.save(new Product(null,"Smart phone",3200,32));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("dddddddd");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("ddddddd");
        System.out.println("----------------");
        List<Product> productList = productRepository.findbyNameContaining("C");
        productList.forEach(p->{
            System.out.println(p);
        });



    }
}
