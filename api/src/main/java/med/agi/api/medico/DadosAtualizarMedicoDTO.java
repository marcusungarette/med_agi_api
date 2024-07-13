package med.agi.api.medico;

import jakarta.validation.constraints.NotNull;
import med.agi.api.endereco.DadosEndereco;

public record DadosAtualizarMedicoDTO(

        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {
}
