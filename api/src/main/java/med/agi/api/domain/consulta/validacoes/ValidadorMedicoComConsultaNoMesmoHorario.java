package med.agi.api.domain.consulta.validacoes;

import med.agi.api.domain.consulta.ConsultaRepository;
import med.agi.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.agi.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorMedicoComConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsultaDTO dados) {
        var medicoPossuiConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiConsultaNoMesmoHorario) {
            throw new ValidacaoException("Medico ja possui outra consulta agendada nesse mesmo horario");
        }
    }
}
