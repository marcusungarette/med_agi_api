package med.agi.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


// Nos Generics da JPA que extends -> Primeiro parametro (Medico:Entidade) - Segundo parametro (Long:Tipo Chave)
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
