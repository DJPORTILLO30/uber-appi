package com.prouxs.UberAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.prouxs.UberAPI.entities.Cliente;
import com.prouxs.UberAPI.repositories.*;
import java.util.Date;

@RestController
@RequestMapping(value ="/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

//metodo crear clientes

    @PostMapping
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Cliente crearClientes(@RequestBody Cliente cliente, @DateTimeFormat(pattern="yyyy.MM.ddd") Date date){
        Cliente nuevoCliente = clienteRepository.save(cliente);
        return nuevoCliente;
    }


}

