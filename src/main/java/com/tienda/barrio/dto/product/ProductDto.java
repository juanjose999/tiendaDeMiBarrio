package com.tienda.barrio.dto.product;

import lombok.Data;

@Data
public class ProductDto {
    private String Nombre;
    private String Descripcion;
    private String Categoria;
    private String Etiquetas;
    private double Precio;
    private String UrlFoto;

    public ProductDto(String Nombre, String Descripcion, String Categoria, String Etiquetas, double Precio, String UrlFoto) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Categoria = Categoria;
        this.Etiquetas = Etiquetas;
        this.Precio = Precio;
        this.UrlFoto = UrlFoto;
    }

}
