package finance.api.model;

import java.time.LocalDateTime;

import finance.api.DTO.UsuarioRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	private String nome; 
	
	@Column(unique = true)	
	private String email; 
	
	
	private String senha;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now(); 
	
	private boolean ativo;
	
	
	public Usuario() {
		super();
	}

	public Usuario(UsuarioRequestDTO dados) {
		
		this.nome = dados.nome();
		this.email = dados.email();
		this.senha = dados.senha();
	}

	public Usuario(Long id, String nome, String email, Boolean ativo) {
		
		super();
		this.id = id; 
		this.nome = nome;
		this.email = email; 
		this.ativo = ativo; 
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	} 
	public Boolean getAtivo() {
		return ativo;
	}
	
}

