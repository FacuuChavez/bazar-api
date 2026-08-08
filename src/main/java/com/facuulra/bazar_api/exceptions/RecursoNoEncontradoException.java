package com.facuulra.bazar_api.exceptions;

public class RecursoNoEncontradoException extends  RuntimeException {
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
