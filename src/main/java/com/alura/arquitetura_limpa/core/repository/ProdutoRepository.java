package com.alura.arquitetura_limpa.core.repository;

import com.alura.arquitetura_limpa.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {

    Produto cadastrarProduto(Produto produto);

    Optional<Produto> buscarPorSKU(String sku);

    void deletarProduto(Long id);

    Optional<Produto> buscarProdutoPorId(Long id);

    List<Produto> buscarProdutos();

}
