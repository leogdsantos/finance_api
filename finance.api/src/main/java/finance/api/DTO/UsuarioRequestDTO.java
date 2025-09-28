package finance.api.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioRequestDTO(
		@NotBlank
		String nome,
		
		@Email
		String email,
		
		@NotBlank
		@Pattern(regexp = "\\d{4,6}")
		String senha 
		
) {

}
