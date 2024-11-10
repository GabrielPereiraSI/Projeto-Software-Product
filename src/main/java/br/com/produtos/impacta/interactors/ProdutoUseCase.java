package br.com.produtos.impacta.interactors;

import br.com.produtos.impacta.entities.ProdutoEntity;

import java.util.List;

public interface ProdutoUseCase {

    ProdutoEntity cadastrar(ProdutoEntity barco);
    List<ProdutoEntity> consultar();
}
