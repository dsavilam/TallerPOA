package com.example.service;

import com.example.model.Producto;
import com.example.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepository productoRepository;

    public ProductoServicioImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updatePrice(Long id, double newPrice) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el producto con id: " + id));
        producto.setPrecio(newPrice);
        productoRepository.save(producto);
    }
}
