package com.senai.techdivem3exercicios.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class RegistroNaoExistenteException extends WebApplicationException {

    public RegistroNaoExistenteException(String tipo, String identificador){
        super(String.format("%s: Registro não encontrado com identificador: %s", tipo, identificador), Response.Status.NOT_FOUND);
    }
}
