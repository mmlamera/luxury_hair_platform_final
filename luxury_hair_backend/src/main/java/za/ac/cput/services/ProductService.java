package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getall() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product createProduct(String hairTexture, String hairStyle, String hairSize,
                                 String hairColor, boolean hairStock, double hairPrice, MultipartFile image ) throws IOException {
      Product product =  new Product.Builder()
                .setHairTexture(hairTexture)
                .setHairStyle(hairStyle)
                .setHairSize(hairSize)
                .setHairColor(hairColor)
                .setHairStock(hairStock)
                .setHairPrice(hairPrice)
                .setImage(image.getBytes())
                .build();

        return productRepository.save(product);
    }

    @Override
    public Product read(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product update(Product product) {
        Optional<Product> existingProduct = productRepository.findById(product.getProductId());
        if (existingProduct.isPresent()) {
            return productRepository.save(product);
        } else {

            return null;
        }
    }

   public boolean delete(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return true;
        } else {
            return false; // Product not found
        }
    }

    public Optional<Product> getProductImage(Long productId) {
        return productRepository.findById(productId);
    }
    public Optional<byte[]> getProductImageById(Long productId) {

        return getProductImage(productId).map(Product::getImage);
    }


   /* public Optional<byte[]> getProductImage(String productId) {
        Product product = read(productId);
        return product != null ? Optional.ofNullable(product.getImage()) : Optional.empty();
    }*/
}
