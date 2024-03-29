package com.tienda.barrio.service.product;


import com.tienda.barrio.dto.product.ProductDto;
import com.tienda.barrio.dto.product.ProductMapper;
import com.tienda.barrio.dto.product.ProductResponseDto;
import com.tienda.barrio.model.product.Producto;
import com.tienda.barrio.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponseDto> getAllProduct() {
        List<Producto> productList = productRepository.getAllProduct();
        productList.forEach(producto -> {
            // Log the 'producto' details
            System.out.println("Product details: " + producto.toString());
        });
        return productList.stream()
                .map(ProductMapper::Product_To_ProductResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto findProductById(String id) {
        return ProductMapper.Product_To_ProductResponseDto(productRepository.findProductById(id));
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productoDto) {
        return ProductMapper.Product_To_ProductResponseDto(productRepository.saveProduct(ProductMapper.ProductDto_To_Product(productoDto)));
    }

    @Override
    public Boolean updateProduct(String id, ProductDto productDto) {
        return productRepository.updateProduct(id, ProductMapper.ProductDto_To_Product(productDto));
    }

    @Override
    public Boolean deleteProductById(String id) {
        return productRepository.deleteProductById(id);
    }
}
