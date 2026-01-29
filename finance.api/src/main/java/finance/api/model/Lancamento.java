package finance.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import Enum.TipoLancamento;
import finance.api.DTO.LancamentoRequestDTO;
import finance.api.DTO.LancamentoUpdateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(unique = true)
	private String descricao; 
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valor; 
	
	
	@CreationTimestamp
	@Column(updatable = false, name = "data_criacao")
	private LocalDateTime dataCriacao;
	
	private LocalDate data; 
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoLancamento tipo; 
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Lancamento() {
		
	}


	public Lancamento(long id, String descricao, BigDecimal valor, LocalDateTime dataCriacao, LocalDate data,
			TipoLancamento tipo, Usuario usuario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.data = data;
		this.tipo = tipo;
		this.usuario = usuario;
	}


	public Lancamento(LancamentoRequestDTO dados, Usuario usuario) {
		
		this.descricao = dados.descricao();
		this.valor = dados.valor();
		this.data = dados.data(); 
		this.tipo = dados.tipo(); 
		this.usuario = usuario; 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public TipoLancamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}  
	public void atulizarLancamento(LancamentoUpdateDTO dados) {
		
		if(dados.descricao()!=null) {
			this.descricao = dados.descricao();
		}
		if(dados.valor()!=null) {
			this.valor = dados.valor();
		}
		if(dados.data()!=null) {
			this.data = dados.data();
		}
		if(dados.tipo()!=null) {
			this.tipo = dados.tipo();
		}
	}
	
	
	

}
