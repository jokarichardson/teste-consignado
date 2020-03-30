package com.richardson.consignado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.richardson.consignado.model.entity.ConsignadoContratado;

@Repository
public interface ConsignadoContratadoRepository extends CrudRepository<ConsignadoContratado, Integer> {

}
