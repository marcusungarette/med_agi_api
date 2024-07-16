package med.agi.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;


// Nos Generics da JPA que extends -> Primeiro parametro (Medico:Entidade) - Segundo parametro (Long:Tipo Chave)
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);


    @Query("""
            SELECT m FROM Medico m
            WHERE
            m.ativo = true
            AND
            m.especialidade = :especialidade
            AND m.id NOT IN(
                SELECT c.medico.id
                FROM Consulta c
                WHERE
                c.data = :data
            )
            ORDER BY FUNCTION('RAND')
            LIMIT 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);
}
