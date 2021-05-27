package com.prouxs.UberAPI.controllers;



import com.prouxs.UberAPI.repositories.PilotoRepository;
import com.prouxs.UberAPI.entities.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/pilotos")
public class PilotoController {

    @Autowired
    PilotoRepository pilotoRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Piloto crearPiloto(@RequestBody Piloto piloto) {
        Piloto nuevoPiloto = pilotoRepository.save(piloto);
        return nuevoPiloto;
    }
}


