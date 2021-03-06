package com.prouxs.UberAPI.repositories;

import com.prouxs.UberAPI.entities.Viaje;
import org.springframework.data.repository.CrudRepository;

public interface ViajeRepository extends CrudRepository<Viaje, Long> {
    Iterable<Viaje> findByestadoEquals(String estado);
}
