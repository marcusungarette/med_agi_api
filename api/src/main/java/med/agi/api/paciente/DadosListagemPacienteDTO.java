package med.agi.api.paciente;

public record DadosListagemPacienteDTO(String nome, String email, String cpf) {
    public DadosListagemPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
