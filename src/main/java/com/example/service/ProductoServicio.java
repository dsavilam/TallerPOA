package com.example.service;

import com.example.model.Producto;
import java.util.List;

public interface ProductoServicio {
    Producto findById(Long id);
    List<Producto> findAll();
    Producto save(Producto producto);
    void delete(Long id);
    void updatePrice(Long id, double newPrice);
}
