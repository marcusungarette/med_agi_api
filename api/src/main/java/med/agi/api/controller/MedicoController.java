package med.agi.api.controller;

import jakarta.validation.Valid;
import med.agi.api.medico.DadosCadastroMedicoDTO;
import med.agi.api.medico.DadosListagemMedicoDTO;
import med.agi.api.medico.Medico;
import med.agi.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // Dependency Injection
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public PagedModel<DadosListagemMedicoDTO> listar(Pageable paginacao){
        return new PagedModel<>(repository.findAll(paginacao).map(DadosListagemMedicoDTO::new)) ;
    }
}
