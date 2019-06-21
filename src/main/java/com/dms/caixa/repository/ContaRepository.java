package com.dms.caixa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dms.caixa.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

	@Query("from Conta c join fetch c.operadora join fetch c.bandeira join fetch c.forma f join fetch f.cartao")
	List<Conta> getAll();
	
	@Query("from Conta c join fetch c.operadora join fetch c.bandeira join fetch c.forma f join fetch f.cartao where c.id=:id")
	Optional<Conta> findById(Integer id);

}
