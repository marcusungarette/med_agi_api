package med.agi.api.domain.consulta.validacoes;

import med.agi.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.agi.api.domain.medico.MedicoRepository;
import med.agi.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsultaDTO dados) {
        //escolha do medico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta nao pode ser agendada com o medico inativo");
        }
    }
}
