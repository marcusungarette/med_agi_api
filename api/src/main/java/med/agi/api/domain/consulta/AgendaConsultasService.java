package med.agi.api.domain.consulta;


import med.agi.api.domain.consulta.cancelamento.DadosCancelamentoConsultaDTO;
import med.agi.api.domain.consulta.cancelamento.ValidadorCancelamentoDeConsulta;
import med.agi.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import med.agi.api.domain.medico.Medico;
import med.agi.api.domain.medico.MedicoRepository;
import med.agi.api.domain.paciente.Paciente;
import med.agi.api.domain.paciente.PacienteRepository;
import med.agi.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaConsultasService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public DadosDetalhamentoConsultaDTO agendar(DadosAgendamentoConsultaDTO dados) {

        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do Paciente informado nao existe!");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do Medico informado nao existe!");
        }

        validadores.forEach(v -> v.validar(dados));

        Paciente paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        Medico medico = escolherMedico(dados);

        if (medico == null) {
            throw new ValidacaoException("Nao existe medico disponivel nessa data");
        }

        Consulta consulta = new Consulta(dados.id(), medico, paciente, dados.data(),(dados.ativo() != null ? dados.ativo() : true));
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsultaDTO(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsultaDTO dados) {
        if (dados.idMedico() != null){
           return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null){
            throw new ValidacaoException("Especialidade e obrigatoria quando medico nao for escolhido");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public DadosDetalhamentoConsultaDTO cancelar(DadosCancelamentoConsultaDTO dados) {
        if (!consultaRepository.existsById(dados.id())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }
        validadoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.id());
        consulta.cancelar(dados.motivo());
        return new DadosDetalhamentoConsultaDTO(consulta);
    }
}
