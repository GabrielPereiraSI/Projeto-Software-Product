package br.com.produtos.impacta.interactors.mapper;

import br.com.produtos.impacta.entities.ProdutoEntity;
import br.com.produtos.impacta.transportlayers.request.CadastroRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoEntity map(CadastroRequest cadastro);

}
