package med.agi.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDTO(Long id, Long idPaciente, Long idMedico, LocalDateTime data) {
}
