package com.tienda.barrio.repository.product;

import com.tienda.barrio.model.product.Producto;

import java.util.List;

public interface ProductRepository {
    List<Producto> getAllProduct();

    Producto findProductById(String id);

    Producto saveProduct(Producto producto);

    Boolean updateProduct(String id, Producto producto);

    Boolean deleteProductById(String id);
}
