package br.com.produtos.impacta.datasources.impl;

import br.com.produtos.impacta.datasources.jdbc.JdbcRepository;
import br.com.produtos.impacta.entities.ProdutoEntity;
import br.com.produtos.impacta.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@PropertySource("classpath:query/produto-sql.properties")
public class ProdutoRepositoryImpl extends JdbcRepository implements ProdutoRepository {

    @Value("${SPI.PRODUTO}")
    protected String criar;

    @Value("${SPU.PRODUTO}")
    protected String alterar;

    @Value("${SPD.PRODUTO}")
    protected String deletar;

    @Value("${SPS.PRODUTO}")
    protected String consultar;

    @Override
    public ProdutoEntity criar(final ProdutoEntity produto) {
        final KeyHolder kh = new GeneratedKeyHolder();
        npjt.update(criar, new BeanPropertySqlParameterSource(produto), kh);
        try {
            produto.setIdProduto(Objects.requireNonNull(kh.getKey()).longValue());
            return produto;
        } catch (final DataRetrievalFailureException e) {
            return null;
        }
    }
}
