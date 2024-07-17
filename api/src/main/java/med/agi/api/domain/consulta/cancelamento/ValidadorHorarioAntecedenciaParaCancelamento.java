package med.agi.api.domain.consulta.cancelamento;

import med.agi.api.domain.consulta.ConsultaRepository;
import med.agi.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaParaCancelamento implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;


    @Override
    public void validar(DadosCancelamentoConsultaDTO dados) {
        var consulta = repository.getReferenceById(dados.id());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}
