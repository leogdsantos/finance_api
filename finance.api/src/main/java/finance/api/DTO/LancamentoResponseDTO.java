package finance.api.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import Enum.TipoLancamento;
import finance.api.model.Lancamento;


public record LancamentoResponseDTO(String descriccao, 
		BigDecimal valor, 
		LocalDate data, 
		TipoLancamento tipo,
		Long usuario_id) {

	public LancamentoResponseDTO(Lancamento lancamento) {
		this(lancamento.getDescricao(), lancamento.getValor(), lancamento.getData(),lancamento.getTipo(),
				lancamento.getUsuario().getId());
	}
}
