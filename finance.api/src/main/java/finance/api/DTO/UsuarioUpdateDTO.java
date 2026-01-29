package finance.api.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UsuarioUpdateDTO(
		
		@NotNull
		Long id, 
		
		
		String nome, 
		
		@Email
		String email, 
		
		@Pattern(regexp = "\\d{4,6}")
		String senha) {

}
