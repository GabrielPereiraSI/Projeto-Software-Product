package br.com.produtos.impacta.entities;

import br.com.produtos.impacta.datasources.jdbc.JdbcDomain;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoEntity extends JdbcDomain {

    private long idProduto;
    private String nome;
    private String marca;
    private String descricao;
    private String tipoProduto;
    private BigDecimal valor;
    private Integer quantidade;

}
