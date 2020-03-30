package com.richardson.consignado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.richardson.consignado.model.entity.BeneficiarioINSS;

@Repository
public interface BeneficiarioINSSRepository extends CrudRepository<BeneficiarioINSS, Integer>, CustomBeneficiarioINSSRepository {
	
}
