package med.agi.api.domain.consulta.cancelamento;

import med.agi.api.domain.consulta.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaCanceladaDTO(Long id, Long idPaciente, Long idMedico, LocalDateTime data, MotivoCancelamento motivo) {
    public DadosDetalhamentoConsultaCanceladaDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getPaciente().getId(), consulta.getMedico().getId(), consulta.getData(), consulta.getMotivo());
    }
}
