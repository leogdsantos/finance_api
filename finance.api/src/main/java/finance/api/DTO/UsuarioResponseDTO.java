package finance.api.DTO;

import finance.api.model.Usuario;

public record UsuarioResponseDTO(Long id, String nome, String email, Boolean ativo) {
	
	public UsuarioResponseDTO(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getAtivo()); 
	}


}
