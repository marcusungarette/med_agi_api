package med.agi.api.domain.paciente;

public record DadosListagemPacienteDTO(Long id, String nome, String email, String cpf) {
    public DadosListagemPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
