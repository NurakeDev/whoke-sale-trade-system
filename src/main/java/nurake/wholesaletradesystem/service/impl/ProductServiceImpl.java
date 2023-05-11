/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:53:46
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.product.Product;
import nurake.wholesaletradesystem.repository.ProductRepository;
import nurake.wholesaletradesystem.rest.dto.ProductDto;
import nurake.wholesaletradesystem.rest.response.ProductResponse;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public SingleResponse getAll() {
        List<Product> all = productRepository.findAll();
        List<ProductResponse> responses = new ArrayList<>();
        for (Product product : all) {
            ProductResponse response = new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getMeasurement(),
                    product.getDescription(),
                    product.getCategory(),
                    product.getWholeSalePrice(),
                    product.getPrice()
            );
            responses.add(response);
        }
        return new SingleResponse(true, "Product List ", responses);
    }

    @Override
    public SingleResponse save(ProductDto productDto) {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setMeasurement(productDto.getMeasurement());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setWholeSalePrice(product.getWholeSalePrice());
        product.setPrice(productDto.getPrice());

        productRepository.save(product);

        return new SingleResponse(true, "Product saved successfully");
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            ProductResponse response = new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getMeasurement(),
                    product.getDescription(),
                    product.getCategory(),
                    product.getWholeSalePrice(),
                    product.getPrice()
            );
            return new SingleResponse(true, "Product with ID {" + id + "}", response);
        }
        return new SingleResponse(false, "Product not found with ID {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse update(Long id, ProductDto dto) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();

            if (dto.getName() != null && !product.getName().equals(dto.getName())){
                product.setName(dto.getName());
            }

            if (dto.getDescription() != null && !product.getDescription().equals(dto.getDescription())){
                product.setDescription(dto.getDescription());
            }

            if (dto.getCategory() != null && !product.getCategory().equals(dto.getCategory())){
                product.setCategory(dto.getCategory());
            }

            if (dto.getMeasurement() != null && !product.getMeasurement().equals(dto.getMeasurement())){
                product.setMeasurement(dto.getMeasurement());
            }

            if (dto.getPrice() != null && !product.getPrice().equals(dto.getPrice())){
                product.setPrice(dto.getPrice());
            }

            if (dto.getWholeSalePrice() != null && !product.getWholeSalePrice().equals(dto.getWholeSalePrice())){
                product.setWholeSalePrice(dto.getWholeSalePrice());
            }

            productRepository.save(product);

            return new SingleResponse(true, "Product updated successfully");
        }
        return new SingleResponse(false, "Product not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            productRepository.delete(product);

            return new SingleResponse(true, "Product successfully deleted", HttpStatus.OK);
        }
        return new SingleResponse(false, "Product not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse getByName(String nameProduct) {

        List<Product> productByName = productRepository.findProductByName(nameProduct);
        List<ProductResponse> responses = new ArrayList<>();
        for (Product product : productByName) {
            ProductResponse response = new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getMeasurement(),
                    product.getDescription(),
                    product.getCategory(),
                    product.getWholeSalePrice(),
                    product.getPrice()
            );
            responses.add(response);
        }
        return new SingleResponse(true, "Product(s) find by name: ", responses);
    }
}
