package med.agi.api.domain.medico;

import med.agi.api.domain.endereco.Endereco;

public record DadosDetalhamentoAtualizacaoMedicoDTO(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Endereco endereco
) {

    public DadosDetalhamentoAtualizacaoMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
