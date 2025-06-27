package com.alura.arquitetura_limpa.entrypoint.controller;

import com.alura.arquitetura_limpa.core.business.ProdutoBusiness;
import com.alura.arquitetura_limpa.domain.Produto;
import com.alura.arquitetura_limpa.entrypoint.controller.dto.ProdutoEntradaDTO;
import com.alura.arquitetura_limpa.entrypoint.controller.dto.ProdutoSaidaDTO;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoBusiness produtoBusiness;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoSaidaDTO cadastrarProduto(@RequestBody @Valid ProdutoEntradaDTO dto) {
        Produto produtoASerCadastrado = dto.toDomain();
        Produto produtoCadastrado = produtoBusiness.cadastrarProduto(produtoASerCadastrado);
        ProdutoSaidaDTO contratoSaida = new ProdutoSaidaDTO().fromDomain(produtoCadastrado);

        return contratoSaida;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id) {
        produtoBusiness.deletarProduto(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoSaidaDTO buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoBusiness.buscarProdutoPorId(id);
        ProdutoSaidaDTO produtoSaidaDTO = new ProdutoSaidaDTO().fromDomain(produto);

        return produtoSaidaDTO;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoSaidaDTO> buscarProdutoPorNome() {
        List<Produto> produtos = produtoBusiness.buscarProdutos();
        List<ProdutoSaidaDTO> produtosSaidaDTO = produtos.stream().map(produto -> new ProdutoSaidaDTO().fromDomain(produto)).toList();

        return produtosSaidaDTO;
    }

}
