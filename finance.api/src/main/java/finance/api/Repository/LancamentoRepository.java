package finance.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import finance.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
