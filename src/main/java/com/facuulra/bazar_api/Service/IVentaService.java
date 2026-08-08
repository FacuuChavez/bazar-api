package com.facuulra.bazar_api.Service;

import com.facuulra.bazar_api.Model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> traerVentas();

    public Venta traerVentaById(Long codigo_venta);

    public Venta crearVenta(Venta unaVenta);

    public void borrarVenta(Long codigo_venta);

    public Venta editarVenta(Long codigo_venta, Venta unaVenta);
}
