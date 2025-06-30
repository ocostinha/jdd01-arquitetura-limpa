package com.alura.arquitetura_limpa.resource.repository;

import com.alura.arquitetura_limpa.core.repository.ProdutoRepository;
import com.alura.arquitetura_limpa.domain.Produto;
import com.alura.arquitetura_limpa.resource.jpa.ProdutoJpaRepository;
import com.alura.arquitetura_limpa.resource.jpa.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Autowired
    private ProdutoJpaRepository produtoJpaRepository;

    @Override
    public Produto cadastrarProduto(final Produto produto) {
        return produtoJpaRepository.save(new ProdutoEntity().fromDomain(produto)).toDomain();
    }

    @Override
    public Optional<Produto> buscarPorSKU(final String sku) {
        return produtoJpaRepository
            .findBySku(sku)
            .map(ProdutoEntity::toDomain);
    }

    @Override
    public void deletarProduto(Long id) {
        produtoJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(final Long id) {
        return produtoJpaRepository
            .findById(id)
            .map(ProdutoEntity::toDomain);
    }

    @Override
    public List<Produto> buscarProdutos() {
        return produtoJpaRepository
            .findAll()
            .stream()
            .map(ProdutoEntity::toDomain)
            .toList();
    }

}
