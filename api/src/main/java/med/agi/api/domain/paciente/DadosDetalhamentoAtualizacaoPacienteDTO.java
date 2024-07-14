package med.agi.api.domain.paciente;

import med.agi.api.domain.endereco.Endereco;

public record DadosDetalhamentoAtualizacaoPacienteDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        Endereco endereco) {

    public DadosDetalhamentoAtualizacaoPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco());
    }
}
