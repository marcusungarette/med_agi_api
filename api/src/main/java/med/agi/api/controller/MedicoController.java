package med.agi.api.controller;

import jakarta.validation.Valid;
import med.agi.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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
    public PagedModel<DadosListagemMedicoDTO> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        return new PagedModel<>(repository.findAll(paginacao).map(DadosListagemMedicoDTO::new)) ;
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedicoDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }
}
