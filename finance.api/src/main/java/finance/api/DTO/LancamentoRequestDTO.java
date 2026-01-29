package finance.api.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import Enum.TipoLancamento;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LancamentoRequestDTO(
		
	    @NotBlank(message = "A descrição é obrigatória")
	    String descricao,

	    @NotNull(message = "O valor é obrigatório")
	    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
	    BigDecimal valor,

	    @NotNull(message = "A data é obrigatória")
	    LocalDate data,

	    @NotNull(message = "O tipo é obrigatório")
	    TipoLancamento tipo,

	    @NotNull(message = "O id do usuário é obrigatório")
	    Long usuarioId
		
		) {
	
}
