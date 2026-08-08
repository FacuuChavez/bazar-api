package com.facuulra.bazar_api.Service;

import com.facuulra.bazar_api.Model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> traerProductos();

    public Producto traerProductoById(Long id);

    public Producto crearProducto(Producto producto);

    public void borrarProducto(Long id);

    public Producto editarProducto(Long id, Producto producto);

}
