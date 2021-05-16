package com.prouxs.UberAPI.controllers;

import com.prouxs.UberAPI.entities.Viaje;
import com.prouxs.UberAPI.repositories.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/viaje")
public class ViajeController {

    @Autowired
    ViajeRepository viajeRepository;

    //POST

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Viaje crearViaje(@RequestBody Viaje viaje){
        return viajeRepository.save(viaje);
    }

}
