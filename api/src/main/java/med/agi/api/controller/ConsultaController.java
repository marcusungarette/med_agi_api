package med.agi.api.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.agi.api.domain.consulta.AgendaConsultasService;
import med.agi.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.agi.api.domain.consulta.cancelamento.DadosCancelamentoConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaConsultasService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO dados){
        var dtoDevolvidoPelaService = service.agendar(dados);
        return ResponseEntity.ok(dtoDevolvidoPelaService);
    }

    @PutMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsultaDTO dados){
        var dtoCancelarConsultaPelaService = service.cancelar(dados);
        return ResponseEntity.ok(dtoCancelarConsultaPelaService);
    }
}
