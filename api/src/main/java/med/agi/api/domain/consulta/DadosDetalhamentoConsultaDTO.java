package med.agi.api.domain.consulta;

import med.agi.api.domain.consulta.cancelamento.MotivoCancelamento;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDTO(Long id, Long idPaciente, Long idMedico, LocalDateTime data) {
    public DadosDetalhamentoConsultaDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getPaciente().getId(), consulta.getMedico().getId(), consulta.getData());
    }
}
