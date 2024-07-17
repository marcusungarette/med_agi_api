package med.agi.api.domain.consulta.validacoes;

import med.agi.api.domain.consulta.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsultaDTO dados);
}
