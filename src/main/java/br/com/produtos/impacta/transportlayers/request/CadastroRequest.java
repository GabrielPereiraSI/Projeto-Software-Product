package br.com.produtos.impacta.transportlayers.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
public class CadastroRequest {

	@NotNull(message = "O Nome é obrigatório.")
	private String nome;

	@NotNull(message = "A Marca é obrigatório.")
	private String marca;

	@NotNull(message = "A descrição é obrigatória.")
	private String descricao;

	@NotNull(message = "O Tipo Produto é obrigatória.")
	private String tipoProduto;

	@NotNull(message = "O valor é obrigatório.")
	@Min(value = 0, message = "O valor deve ser maior ou igual a zero.")
	private BigDecimal valor;

	@NotNull(message = "A quantidade é obrigatória.")
	@Min(value = 1, message = "A quantidade deve ser pelo menos 1.")
	private Integer quantidade;
}
