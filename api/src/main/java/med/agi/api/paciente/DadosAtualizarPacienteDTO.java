package med.agi.api.paciente;


import jakarta.validation.Valid;
import med.agi.api.endereco.DadosEndereco;

public record DadosAtualizarPacienteDTO(
        Long id,
        String nome,
        String telefone,

        @Valid
        DadosEndereco endereco) {
}
