package com.alura.arquitetura_limpa.entrypoint.controller.dto;

import com.alura.arquitetura_limpa.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoSaidaDTO {

    private Long id;
    private String sku;
    private String nome;
    private String descricao;
    private Double preco;
    private LocalDateTime dataHoraConsulta;

    public ProdutoSaidaDTO fromDomain (Produto produto) {
        this.id = produto.getId();
        this.sku = produto.getSku();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.dataHoraConsulta = LocalDateTime.now();

        return this;
    }

}
