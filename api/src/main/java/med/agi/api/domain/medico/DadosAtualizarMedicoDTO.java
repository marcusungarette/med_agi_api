package med.agi.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.agi.api.domain.endereco.DadosEndereco;

public record DadosAtualizarMedicoDTO(

        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {
}
