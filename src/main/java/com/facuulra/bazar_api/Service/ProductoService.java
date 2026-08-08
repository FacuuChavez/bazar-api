package com.facuulra.bazar_api.Service;

import com.facuulra.bazar_api.Model.Producto;
import com.facuulra.bazar_api.Repository.IProductoRepository;
import com.facuulra.bazar_api.exceptions.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements  IProductoService {

    @Autowired
    private IProductoRepository prodRepo;

    @Override
    public List<Producto> traerProductos() {
        return prodRepo.findAll();
    }

    @Override
    public Producto traerProductoById(Long id) {
        Producto productoEncontrado =  prodRepo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el producto con ID: " + id));
        return productoEncontrado;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        prodRepo.save(producto);
        return producto;
    }

    @Override
    public void borrarProducto(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public Producto editarProducto(Long id, Producto producto) {
        Producto productoEncontrado = this.traerProductoById(id);

        productoEncontrado.setNombre(producto.getNombre());
        productoEncontrado.setMarca(producto.getMarca());
        productoEncontrado.setCosto(producto.getCosto());
        productoEncontrado.setCantidad_disponible(producto.getCantidad_disponible());
        productoEncontrado.setListaVentas(producto.getListaVentas());

        prodRepo.save(productoEncontrado);

        return productoEncontrado;

    }

}

