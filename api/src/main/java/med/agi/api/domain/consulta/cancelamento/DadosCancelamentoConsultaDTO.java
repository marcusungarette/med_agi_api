package med.agi.api.domain.consulta.cancelamento;

import jakarta.validation.constraints.NotNull;


public record DadosCancelamentoConsultaDTO(
        @NotNull
        Long id,

        MotivoCancelamento motivo

) {
}
