package com.facuulra.bazar_api.Controller;

import com.facuulra.bazar_api.Model.Producto;
import com.facuulra.bazar_api.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService prodServ;

    @GetMapping
    public ResponseEntity<List<Producto>> traerProductos(){
        return ResponseEntity.ok(prodServ.traerProductos());
    }

    @GetMapping("/{codigo_producto}")
    public ResponseEntity<Producto> traerProducto(@PathVariable Long codigo_producto){
        return ResponseEntity.ok(prodServ.traerProductoById(codigo_producto));
    }

    @GetMapping("/falta_stock")
    public ResponseEntity<List<Producto>> traerProductosMenosDe5(){
        return ResponseEntity.ok(prodServ.traerProductosCantidadMenosDe5());
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(prodServ.crearProducto(producto));
    }

    @DeleteMapping("/eliminar/{codigo_producto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long codigo_producto){
        prodServ.borrarProducto(codigo_producto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editar/{codigo_producto}")
    public ResponseEntity<Producto> editarProducto(@PathVariable Long codigo_producto, @RequestBody Producto producto){
        return ResponseEntity.ok(prodServ.editarProducto(codigo_producto, producto));
    }

}
