package com.alura.arquitetura_limpa.entrypoint.controller;

import com.alura.arquitetura_limpa.core.business.ProdutoBusiness;
import com.alura.arquitetura_limpa.entrypoint.controller.dto.ProdutoEntradaDTO;
import com.alura.arquitetura_limpa.entrypoint.controller.dto.ProdutoSaidaDTO;
import jakarta.validation.Valid;
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
        return new ProdutoSaidaDTO()
            .fromDomain(produtoBusiness.cadastrarProduto(dto.toDomain()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id) {
        produtoBusiness.deletarProduto(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoSaidaDTO buscarProdutoPorId(@PathVariable Long id) {
        return new ProdutoSaidaDTO()
            .fromDomain(produtoBusiness.buscarProdutoPorId(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoSaidaDTO> buscarProdutoPorNome() {
        return produtoBusiness.buscarProdutos()
            .stream()
            .map(produto -> new ProdutoSaidaDTO().fromDomain(produto))
            .toList();
    }

}
