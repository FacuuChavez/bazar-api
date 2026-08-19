package com.facuulra.bazar_api.Service;

import com.facuulra.bazar_api.Dto.VentasDiaDTO;
import com.facuulra.bazar_api.Model.Producto;
import com.facuulra.bazar_api.Model.Venta;
import com.facuulra.bazar_api.Repository.IVentaRepository;
import com.facuulra.bazar_api.exceptions.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<Producto> traerProductosDeUnaVenta(long codigo_venta) {
        Venta unaVenta = this.traerVentaById(codigo_venta);
        List<Producto> listaProductos = unaVenta.getListaProductos();
        return listaProductos;
    }

    @Override
    public VentasDiaDTO traerMontoYTotalDeVentas(LocalDate fecha_venta) {
        List<Venta> listaVentasDelDia = this.traerVentas().stream().filter(venta -> fecha_venta.equals(venta.getFecha_venta())).toList();
        Integer cantidadDeVentas = listaVentasDelDia.size();
        Double montoTotal = listaVentasDelDia.stream().mapToDouble(ventas -> ventas.getTotal()).sum();

        VentasDiaDTO resumenDelDia = new VentasDiaDTO();
        resumenDelDia.setCantidad_ventas(cantidadDeVentas);
        resumenDelDia.setMontoTotal(montoTotal);
        return resumenDelDia;
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
