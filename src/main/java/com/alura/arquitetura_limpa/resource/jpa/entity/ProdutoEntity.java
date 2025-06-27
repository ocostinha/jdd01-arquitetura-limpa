package com.alura.arquitetura_limpa.resource.jpa.entity;

import com.alura.arquitetura_limpa.domain.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String nome;
    private String descricao;
    private Double preco;

    public ProdutoEntity fromDomain(Produto produto) {
        this.sku = produto.getSku();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();

        return this;
    }

    public Produto toDomain() {
        return new Produto(this.id, this.sku, this.nome, this.descricao, this.preco);
    }

}
