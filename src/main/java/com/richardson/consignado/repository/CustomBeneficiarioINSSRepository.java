package com.richardson.consignado.repository;

import java.util.List;

import com.richardson.consignado.model.entity.BeneficiarioINSS;

public interface CustomBeneficiarioINSSRepository {
	List<BeneficiarioINSS> getOfertas();
	List<BeneficiarioINSS> getOfertasAutorizadas();
}
