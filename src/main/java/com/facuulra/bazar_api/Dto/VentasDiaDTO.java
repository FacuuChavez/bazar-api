package com.facuulra.bazar_api.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class VentasDiaDTO {
    private Integer cantidad_ventas;
    private Double montoTotal;

}
