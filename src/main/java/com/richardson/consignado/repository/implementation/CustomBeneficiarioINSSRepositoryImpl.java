package com.richardson.consignado.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.richardson.consignado.model.entity.BeneficiarioINSS;
import com.richardson.consignado.repository.CustomBeneficiarioINSSRepository;

public class CustomBeneficiarioINSSRepositoryImpl implements CustomBeneficiarioINSSRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BeneficiarioINSS> getOfertas() {
		TypedQuery<BeneficiarioINSS> query = entityManager.createQuery(
				"SELECT b FROM BeneficiarioINSS b "
						+ "WHERE TIMESTAMPDIFF('DAY', b.dataDespachoBeneficio, CURRENT_DATE) >= 180",
				BeneficiarioINSS.class);

		return query.getResultList();
	}

	@Override
	public List<BeneficiarioINSS> getOfertasAutorizadas() {
		TypedQuery<BeneficiarioINSS> query = entityManager.createQuery(
				"SELECT b FROM BeneficiarioINSS b " + "WHERE b.dataAutorizacaoConsulta IS NOT NULL "
						+ "AND TIMESTAMPDIFF('DAY', b.dataDespachoBeneficio, b.dataAutorizacaoConsulta) >= 90",
				BeneficiarioINSS.class);

		return query.getResultList();
	}
}
