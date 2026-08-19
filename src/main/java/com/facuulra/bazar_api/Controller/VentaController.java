package com.facuulra.bazar_api.Controller;

import com.facuulra.bazar_api.Dto.VentasDiaDTO;
import com.facuulra.bazar_api.Model.Producto;
import com.facuulra.bazar_api.Model.Venta;
import com.facuulra.bazar_api.Service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    @GetMapping
    public ResponseEntity<List<Venta>> traerVentas(){
        return ResponseEntity.ok(ventaServ.traerVentas());
    }

    @GetMapping("/{codigo_venta}")
    public ResponseEntity<Venta> traerVentaPorId(@PathVariable Long codigo_venta){
        return ResponseEntity.ok(ventaServ.traerVentaById(codigo_venta));
    }

    @GetMapping("/productos/{codigo_venta}")
    public ResponseEntity<List<Producto>> traerProductosDeUnaVenta(@PathVariable Long codigo_venta){
        return ResponseEntity.ok(ventaServ.traerProductosDeUnaVenta(codigo_venta));
    }

    @GetMapping("/{fecha_venta}")
    public ResponseEntity<VentasDiaDTO> traerMontoYTotalDeVentas(@PathVariable LocalDate fecha_venta){
        return ResponseEntity.ok(ventaServ.traerMontoYTotalDeVentas(fecha_venta));
    }

    @PostMapping("/crear")
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta unaVenta){
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaServ.crearVenta(unaVenta));
    }

    @DeleteMapping("/eliminar/{codigo_venta}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long codigo_venta){
        ventaServ.borrarVenta(codigo_venta);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editar/{codigo_venta}")
    public ResponseEntity<Venta> editarVenta(@PathVariable Long codigo_venta, @RequestBody Venta cliente){
        return ResponseEntity.ok(ventaServ.editarVenta(codigo_venta, cliente));
    }
}
