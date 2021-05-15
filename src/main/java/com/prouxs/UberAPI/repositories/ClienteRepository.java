package com.prouxs.UberAPI.repositories;

import com.prouxs.UberAPI.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
