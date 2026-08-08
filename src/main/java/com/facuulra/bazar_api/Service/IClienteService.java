package com.facuulra.bazar_api.Service;

import com.facuulra.bazar_api.Model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> traerClientes();

    public Cliente traerClienteById(Long id);

    public Cliente crearCliente(Cliente cliente);

    public void borrarCliente(Long id);

    public Cliente editarCliente(Long id, Cliente cliente);
}
