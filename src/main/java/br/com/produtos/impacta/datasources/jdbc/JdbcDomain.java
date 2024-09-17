package br.com.produtos.impacta.datasources.jdbc;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author hendrix.schmidt
 *
 */
public class JdbcDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	protected LocalDateTime dtInclusao;
	protected LocalDateTime dtAlteracao;
	
	public JdbcDomain() {
		super();
	}

	public JdbcDomain(LocalDateTime dtInclusao) {
		super();
		this.dtInclusao = LocalDateTime.now();
	}

	public LocalDateTime getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(LocalDateTime dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public LocalDateTime getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(LocalDateTime dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
