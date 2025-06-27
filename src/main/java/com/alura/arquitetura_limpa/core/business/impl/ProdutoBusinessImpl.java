package com.alura.arquitetura_limpa.core.business.impl;

import com.alura.arquitetura_limpa.core.business.ProdutoBusiness;
import com.alura.arquitetura_limpa.core.repository.ProdutoRepository;
import com.alura.arquitetura_limpa.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoBusinessImpl implements ProdutoBusiness {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto cadastrarProduto(final Produto produto) {
        if (produtoRepository.buscarPorSKU(produto.getSku()).isPresent()) {
            throw new RuntimeException("Produto já cadastrado");
        }

        Produto produtoSalvo = produtoRepository.cadastrarProduto(produto);

        return produtoSalvo;
    }

    @Override
    public void deletarProduto(Long id) {
        produtoRepository.deletarProduto(id);
    }

    @Override
    public Produto buscarProdutoPorId(final Long id) {
        Optional<Produto> produtoConsultado = produtoRepository.buscarProdutoPorId(id);

        if (produtoConsultado.isEmpty()){
            throw new RuntimeException("Produto não encontrado");
        }

        return produtoConsultado.get();
    }

    @Override
    public List<Produto> buscarProdutos() {
        List<Produto> produtosConsultados = produtoRepository.buscarProdutos();

        return produtosConsultados;
    }

}
