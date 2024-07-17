package med.agi.api.domain.consulta.validacoes;

import med.agi.api.domain.consulta.ConsultaRepository;
import med.agi.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.agi.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsultaDTO dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
            if (pacientePossuiOutraConsultaNoDia) {
                throw new ValidacaoException("Paciente ja possui uma consulta agendada nesse dia");
            }
        }
    }

