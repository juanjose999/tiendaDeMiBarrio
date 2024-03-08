package com.tienda.barrio.dto.product;


import com.tienda.barrio.model.product.Producto;

public class ProductMapper {

    public static ProductResponseDto Product_To_ProductResponseDto(Producto producto){
        if(producto==null){
            return null;
        }

        return new ProductResponseDto(
                producto.getIdProduct(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCategoria(),
                producto.getEtiquetas(),
                producto.getPrecio(),
                producto.getUrlFoto()
        );
    }

    public static Producto ProductDto_To_Product (ProductDto productDto){

        double precio = (productDto.getPrecio() == 0) ? 0.0 : productDto.getPrecio();
        return new Producto(
                productDto.getNombre(),
                productDto.getDescripcion(),
                productDto.getCategoria(),
                productDto.getEtiquetas(),
                precio,
                productDto.getUrlFoto()
        );
    }

}
