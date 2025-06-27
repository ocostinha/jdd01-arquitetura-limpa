package com.alura.arquitetura_limpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private Long id;
    //Regra de negócio, sku não pode ter duplicidade no sistema
    private String sku;
    private String nome;
    private String descricao;
    private Double preco;
}
