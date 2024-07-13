package med.agi.api.controller;

import jakarta.validation.Valid;
import med.agi.api.paciente.DadosCadastroPacienteDTO;
import med.agi.api.paciente.DadosListagemPacienteDTO;
import med.agi.api.paciente.Paciente;
import med.agi.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPacienteDTO dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public PagedModel<DadosListagemPacienteDTO> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        return new PagedModel<>(repository.findAll(paginacao).map(DadosListagemPacienteDTO::new)) ;
    }
}

