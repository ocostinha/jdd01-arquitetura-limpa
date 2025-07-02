package com.alura.arquitetura_limpa.core.business.impl;

import com.alura.arquitetura_limpa.core.business.ProdutoBusiness;
import com.alura.arquitetura_limpa.core.repository.ProdutoRepository;
import com.alura.arquitetura_limpa.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoBusinessImpl implements ProdutoBusiness {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto cadastrarProduto(final Produto produto) {
        produtoRepository.buscarPorSKU(produto.getSku())
            .ifPresent(_ -> {
                throw new RuntimeException("Produto já cadastrado");
            });

        return produtoRepository.cadastrarProduto(produto);
    }

    @Override
    public void deletarProduto(Long id) {
        produtoRepository.deletarProduto(id);
    }

    @Override
    public Produto buscarProdutoPorId(final Long id) {
        return produtoRepository.buscarProdutoPorId(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @Override
    public List<Produto> buscarProdutos() {
        return produtoRepository.buscarProdutos();
    }

}
