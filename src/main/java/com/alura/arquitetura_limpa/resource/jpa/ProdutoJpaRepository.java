package com.alura.arquitetura_limpa.resource.jpa;

import com.alura.arquitetura_limpa.resource.jpa.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {

    Optional<ProdutoEntity> findBySku(String sku);

}
