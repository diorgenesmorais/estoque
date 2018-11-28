package com.dms.caixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.caixa.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
