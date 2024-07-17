package med.agi.api.domain.consulta;


import med.agi.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import med.agi.api.domain.medico.DadosDetalhamentoAtualizacaoMedicoDTO;
import med.agi.api.domain.medico.Medico;
import med.agi.api.domain.medico.MedicoRepository;
import med.agi.api.domain.paciente.Paciente;
import med.agi.api.domain.paciente.PacienteRepository;
import med.agi.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Consulta consulta = new Consulta(dados.id(), medico, paciente, dados.data());
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
}
