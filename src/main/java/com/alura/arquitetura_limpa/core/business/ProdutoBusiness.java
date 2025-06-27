package com.alura.arquitetura_limpa.core.business;

import com.alura.arquitetura_limpa.domain.Produto;

import java.util.List;

public interface ProdutoBusiness {

    Produto cadastrarProduto(Produto produto);

    void deletarProduto(Long id);

    Produto buscarProdutoPorId(Long id);

    List<Produto> buscarProdutos();

}
