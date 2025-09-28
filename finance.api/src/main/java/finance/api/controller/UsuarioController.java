package finance.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finance.api.DTO.UsuarioRequestDTO;
import finance.api.DTO.UsuarioResponseDTO;
import finance.api.Repository.UsuarioRepository;
import finance.api.model.Usuario;



@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository; 
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody UsuarioRequestDTO dados) {
		repository.save(new Usuario(dados));
	}
	
	@GetMapping
	public Page<UsuarioResponseDTO> listar(Pageable paginacao){
		return repository.findAll(paginacao).map(UsuarioResponseDTO::new); 
	}


	public String teste() {
	    return "API funcionando!";
	}
}

