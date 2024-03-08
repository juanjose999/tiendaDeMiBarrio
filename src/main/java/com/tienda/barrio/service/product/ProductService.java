package com.tienda.barrio.service.product;


import com.tienda.barrio.dto.product.ProductDto;
import com.tienda.barrio.dto.product.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProduct();

    ProductResponseDto findProductById(String id);

    ProductResponseDto saveProduct(ProductDto productoDto);

    Boolean updateProduct(String id, ProductDto productDto);

    Boolean deleteProductById(String id);

}
