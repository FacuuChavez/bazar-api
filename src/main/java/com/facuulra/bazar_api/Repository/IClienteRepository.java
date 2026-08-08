package com.facuulra.bazar_api.Repository;

import com.facuulra.bazar_api.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
