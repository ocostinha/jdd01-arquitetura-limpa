package com.alura.arquitetura_limpa.entrypoint.controller.dto;

import com.alura.arquitetura_limpa.domain.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntradaDTO {

    @NotNull
    @NotEmpty
    private String sku;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String descricao;

    @NotNull
    @Min(1)
    private Double preco;

    public Produto toDomain() {
        return new Produto(null, sku, nome, descricao, preco);
    }

}
