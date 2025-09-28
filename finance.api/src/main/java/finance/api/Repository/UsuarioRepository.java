package finance.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import finance.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
