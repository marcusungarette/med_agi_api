package med.agi.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.agi.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsultaDTO(
        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime data,   ///@JsonAlias({“data_da_consulta”, “data_consulta”}) LocalDateTime data
                              ///@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        Especialidade especialidade

) {
}
