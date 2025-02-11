package br.com.produtos.impacta.datasources.impl;

import br.com.produtos.impacta.datasources.jdbc.JdbcRepository;
import br.com.produtos.impacta.entities.ProdutoEntity;
import br.com.produtos.impacta.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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

    @Value("${SPS.PRODUTO_ID}")
    protected String consultarById;

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

    @Override
    public List<ProdutoEntity> consultar() {
        var result = npjt.query(consultar, BeanPropertyRowMapper.newInstance(ProdutoEntity.class));
        return result.isEmpty() ? new ArrayList<>() : result;
    }

    @Override
    public ProdutoEntity consultarById(Long produtoId) {
        final MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("produtoId", produtoId);
        return npjt.query(consultarById, parametros, BeanPropertyRowMapper.newInstance(ProdutoEntity.class)).get(0);
    }

    @Override
    public void alterar(ProdutoEntity produto) {
        final MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("nome", produto.getNome());
        parametros.addValue("marca", produto.getMarca());
        parametros.addValue("tipoProduto", produto.getTipoProduto());
        parametros.addValue("valor", produto.getValor());
        parametros.addValue("quantidade", produto.getQuantidade());
        parametros.addValue("idProduto", produto.getIdProduto());
        npjt.update(alterar, parametros);
    }

    @Override
    public void deletar(Long produtoId) {
        final MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("produtoId", produtoId);
        npjt.update(deletar, parametros);
    }
}
