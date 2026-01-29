package finance.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finance.api.DTO.LancamentoRequestDTO;
import finance.api.DTO.LancamentoResponseDTO;
import finance.api.DTO.LancamentoUpdateDTO;
import finance.api.Repository.LancamentoRepository;
import finance.api.Repository.UsuarioRepository;
import finance.api.model.Lancamento;
import finance.api.model.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoRepository lancamentoRepository; 
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private Lancamento lancamento;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody LancamentoRequestDTO dados) {
		
		Usuario usuario = usuarioRepository.findById(dados.usuarioId())
				.orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));
		
		lancamentoRepository.save(new Lancamento(dados, usuario)); 
	}
	
	@GetMapping
	public Page<LancamentoResponseDTO>listar(Pageable paginacao){
		return lancamentoRepository.findAll(paginacao).map(LancamentoResponseDTO::new); 
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizarLancamento(@PathVariable Long id, @RequestBody @Valid LancamentoUpdateDTO dados) {
		lancamento = lancamentoRepository.getReferenceById(id); 
		lancamento.atulizarLancamento(dados); 
	}
}
