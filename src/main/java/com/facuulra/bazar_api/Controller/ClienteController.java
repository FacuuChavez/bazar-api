package com.facuulra.bazar_api.Controller;

import com.facuulra.bazar_api.Model.Cliente;
import com.facuulra.bazar_api.Service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService cliService;

    @GetMapping
    public ResponseEntity<List<Cliente>> traerClientes(){
        return ResponseEntity.ok(cliService.traerClientes());
    }

    @GetMapping("/{codigo_cliente}")
    public ResponseEntity<Cliente> traerClientePorId(@PathVariable Long codigo_cliente){
        return ResponseEntity.ok(cliService.traerClienteById(codigo_cliente));
    }

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(cliService.crearCliente(cliente));
    }

    @DeleteMapping("/eliminar/{codigo_cliente}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long codigo_cliente){
        cliService.borrarCliente(codigo_cliente);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editar/{codigo_cliente}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable Long codigo_cliente, @RequestBody Cliente cliente){
        return ResponseEntity.ok(cliService.editarCliente(codigo_cliente, cliente));
    }
}
