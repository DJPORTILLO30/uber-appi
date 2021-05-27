package com.prouxs.UberAPI.controllers;



import com.prouxs.UberAPI.entities.Viaje;
import com.prouxs.UberAPI.repositories.PilotoRepository;
import com.prouxs.UberAPI.entities.Piloto;
import com.prouxs.UberAPI.repositories.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/pilotos")
public class PilotoController {

    @Autowired
    PilotoRepository pilotoRepository;
    @Autowired
    ViajeRepository viajeRepository;

    //Get viajes creados
    @GetMapping(value = "/viajes")
    @ResponseStatus(code = HttpStatus.OK)
    public Collection<Viaje> getViajes(){
        Iterable<Viaje> viaje = viajeRepository.findByestadoEquals("Creado");
        return (Collection<Viaje>) viaje;
    }

    // EDIT
    @PutMapping(value = "/{id_piloto}/{id_viaje}")
    @Transactional
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Viaje editIdPiloto(@PathVariable(name = "id_piloto") Long id_piloto,@PathVariable(name = "id_viaje") Long id_viaje, @RequestBody Viaje categoria){
        Optional<Viaje> anterior = viajeRepository.findById(id_viaje);
        if (anterior.isPresent()){
            Viaje nuevo = anterior.get();
            nuevo.setIdPiloto(id_piloto);
            return viajeRepository.save(nuevo);
        }
        return null;
    }

    //actualizar estado a en marcha
    @PutMapping(value = "/{id_piloto}/{id_viaje}/aceptar")
    @Transactional
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Viaje editEstadoEnMarcha(@PathVariable(name = "id_piloto") Long id_piloto,@PathVariable(name = "id_viaje") Long id_viaje, @RequestBody Viaje categoria){
        Optional<Viaje> anterior = viajeRepository.findById(id_viaje);
        if (anterior.isPresent()){
            Viaje nuevo = anterior.get();
            nuevo.setEstado("En marcha");
            return viajeRepository.save(nuevo);
        }
        return null;
    }

    //actualizar estado a terminar
    @PutMapping(value = "/{id_piloto}/{id_viaje}/finalizar")
    @Transactional
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Viaje editFinalizarviaje(@PathVariable(name = "id_piloto") Long id_piloto,@PathVariable(name = "id_viaje") Long id_viaje, @RequestBody Viaje categoria){
        Optional<Viaje> anterior = viajeRepository.findById(id_viaje);
        if (anterior.isPresent()){
            Viaje nuevo = anterior.get();
            nuevo.setEstado("Finalizar");
            nuevo.setMonto(500);
            return viajeRepository.save(nuevo);
        }
        return null;
    }

    //nuevo piloto
    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Piloto crearPiloto(@RequestBody Piloto piloto) {
        Piloto nuevoPiloto = pilotoRepository.save(piloto);
        return nuevoPiloto;
    }

    //lista de pilotos
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Collection<Piloto> getPilotos(){
        Iterable<Piloto> pilotos = pilotoRepository.findAll();
        return (Collection<Piloto>) pilotos;
    }

}


