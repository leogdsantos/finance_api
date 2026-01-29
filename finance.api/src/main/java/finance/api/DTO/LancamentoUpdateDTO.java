package finance.api.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import Enum.TipoLancamento;
import jakarta.validation.constraints.DecimalMin;

public record LancamentoUpdateDTO(
		
	
	    String descricao,

	    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
	    BigDecimal valor,

	    LocalDate data,

	    TipoLancamento tipo 
	    
		) {

}
