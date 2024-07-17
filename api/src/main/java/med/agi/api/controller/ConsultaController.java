package med.agi.api.controller;


import jakarta.validation.Valid;
import med.agi.api.domain.consulta.AgendaConsultasService;
import med.agi.api.domain.consulta.DadosAgendamentoConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaConsultasService agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO dados){
        var dtoDevolvidoPelaService = agenda.agendar(dados);
        return ResponseEntity.ok(dtoDevolvidoPelaService);
    }
}
