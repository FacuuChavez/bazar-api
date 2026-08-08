package com.facuulra.bazar_api.Service;

import com.facuulra.bazar_api.Model.Cliente;
import com.facuulra.bazar_api.Repository.IClienteRepository;
import com.facuulra.bazar_api.exceptions.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository cliRepo;

    @Override
    public List<Cliente> traerClientes() {
        return cliRepo.findAll();
    }

    @Override
    public Cliente traerClienteById(Long id) {
        Cliente clienteEncontrado = cliRepo.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Cliente no encontrado"));
        return clienteEncontrado;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        Cliente clienteCreado = cliRepo.save(cliente);
        return clienteCreado;
    }

    @Override
    public void borrarCliente(Long id) {
        Cliente clienteABorrar = this.traerClienteById(id);
        cliRepo.delete(clienteABorrar);
    }

    @Override
    public Cliente editarCliente(Long id, Cliente cliente) {
        Cliente clienteAEditar = this.traerClienteById(id);
        clienteAEditar.setNombre(cliente.getNombre());
        clienteAEditar.setApellido(cliente.getApellido());
        clienteAEditar.setDni(cliente.getDni());
        clienteAEditar.setListaVentas(cliente.getListaVentas());

        cliRepo.save(clienteAEditar);

        return clienteAEditar;
    }
}
