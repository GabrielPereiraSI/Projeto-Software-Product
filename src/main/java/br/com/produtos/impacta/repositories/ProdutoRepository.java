package br.com.produtos.impacta.repositories;

import br.com.produtos.impacta.entities.ProdutoEntity;

import java.util.List;

public interface ProdutoRepository {

    ProdutoEntity criar(ProdutoEntity barco);
    List<ProdutoEntity> consultar();
    ProdutoEntity consultarById(Long produtoId);
    void alterar(ProdutoEntity produto);
    void deletar(Long produtoId);
}
