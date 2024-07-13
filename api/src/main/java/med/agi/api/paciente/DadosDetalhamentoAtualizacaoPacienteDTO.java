package med.agi.api.paciente;

import med.agi.api.endereco.Endereco;

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
