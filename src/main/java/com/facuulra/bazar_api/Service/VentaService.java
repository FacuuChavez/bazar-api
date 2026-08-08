package com.facuulra.bazar_api.Service;

import com.facuulra.bazar_api.Model.Venta;
import com.facuulra.bazar_api.Repository.IVentaRepository;
import com.facuulra.bazar_api.exceptions.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public List<Venta> traerVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta traerVentaById(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElseThrow(() -> new RecursoNoEncontradoException("Venta no encontrada "));
    }

    @Override
    public Venta crearVenta(Venta unaVenta) {
        return ventaRepo.save(unaVenta);
    }

    @Override
    public void borrarVenta(Long codigo_venta) {
        Venta ventaABorrar = this.traerVentaById(codigo_venta);
        ventaRepo.delete(ventaABorrar);
    }

    @Override
    public Venta editarVenta(Long codigo_venta, Venta unaVenta) {
        Venta ventaAEditar = this.traerVentaById(codigo_venta);
        ventaAEditar.setFecha_venta(unaVenta.getFecha_venta());
        ventaAEditar.setListaProductos(unaVenta.getListaProductos());
        ventaAEditar.setTotal(unaVenta.getTotal());
        ventaAEditar.setUnCliente(unaVenta.getUnCliente());

        ventaRepo.save(ventaAEditar);

        return ventaAEditar;
    }
}
