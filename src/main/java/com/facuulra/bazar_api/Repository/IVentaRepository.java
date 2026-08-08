package com.facuulra.bazar_api.Repository;

import com.facuulra.bazar_api.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta,Long> {
}
