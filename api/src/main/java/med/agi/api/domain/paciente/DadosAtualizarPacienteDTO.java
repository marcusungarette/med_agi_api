package med.agi.api.domain.paciente;


import jakarta.validation.Valid;
import med.agi.api.domain.endereco.DadosEndereco;

public record DadosAtualizarPacienteDTO(
        Long id,
        String nome,
        String telefone,

        @Valid
        DadosEndereco endereco) {
}
