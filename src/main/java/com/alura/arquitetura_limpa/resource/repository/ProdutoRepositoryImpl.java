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
        ProdutoEntity produtoASerCadastrado = new ProdutoEntity().fromDomain(produto);
        ProdutoEntity produtoCadastrado = produtoJpaRepository.save(produtoASerCadastrado);
        Produto produtoConvertido = produtoCadastrado.toDomain();

        return produtoConvertido;
    }

    @Override
    public Optional<Produto> buscarPorSKU(final String sku) {
        Optional<ProdutoEntity> buscaPorSku = produtoJpaRepository.findBySku(sku);

        return buscaPorSku.map(ProdutoEntity::toDomain);
    }

    @Override
    public void deletarProduto(Long id) {
        produtoJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(final Long id) {
        Optional<ProdutoEntity> produtoConsultado = produtoJpaRepository.findById(id);

        return produtoConsultado.map(ProdutoEntity::toDomain);
    }

    @Override
    public List<Produto> buscarProdutos() {
        List<ProdutoEntity> produtosConsultados = produtoJpaRepository.findAll();

        return produtosConsultados.stream().map(ProdutoEntity::toDomain).toList();
    }

}
