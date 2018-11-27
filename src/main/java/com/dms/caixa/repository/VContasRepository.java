package com.dms.caixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.caixa.model.VContas;

public interface VContasRepository extends JpaRepository<VContas, Integer> {

	VContas findByConta(String conta);

}
