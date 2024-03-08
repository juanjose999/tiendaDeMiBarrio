package com.tienda.barrio.repository.product.mongo;


import com.tienda.barrio.model.product.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<Producto, String> {
}
