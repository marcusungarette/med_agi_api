package med.agi.api.domain.consulta.validacoes;

import med.agi.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.agi.api.domain.paciente.PacienteRepository;
import med.agi.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsultaDTO dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta nao pode ser agendada com paciente excluido");
        }
    }
}
