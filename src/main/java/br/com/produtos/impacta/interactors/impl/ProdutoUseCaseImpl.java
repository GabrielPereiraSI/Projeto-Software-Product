package br.com.produtos.impacta.interactors.impl;

import br.com.produtos.impacta.entities.ProdutoEntity;
import br.com.produtos.impacta.interactors.ProdutoUseCase;
import br.com.produtos.impacta.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoEntity cadastrar(ProdutoEntity barco) {
        return produtoRepository.criar(barco);
    }

    @Override
    public List<ProdutoEntity> consultar() {
        return produtoRepository.consultar();
    }

    @Override
    public ProdutoEntity consultarById(Long produtoId) {
        return produtoRepository.consultarById(produtoId);
    }

    @Override
    public void alterarProduto(ProdutoEntity produto) {
        produtoRepository.alterar(produto);
    }

    @Override
    public void deletarProduto(Long produtoId) {
        produtoRepository.deletar(produtoId);
    }
}
