package dev.iurexavier.CadastroDeNinjas.missao.controller;

import dev.iurexavier.CadastroDeNinjas.missao.service.MissaoService;
import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService service;

    public MissaoController(MissaoService service) {
        this.service = service;
    }

    // GET - Mandar uma requisicao para buscar missões
    @GetMapping
    public List<MissaoModel> listarMissoes() {
        return service.listarMissoes();
    }

    // GET - Buscar missões por ID
    @GetMapping("/{id}")
    public MissaoModel procurarMissaoPorId(@PathVariable Long id) {
        return service.procurarMissaoPorId(id);
    }

    // POST - Mandar uma requisicao para criar missões
    @PostMapping
    public MissaoModel criarMissao(@RequestBody MissaoModel missao) {
        return service.criarMissao(missao);
    }

    // PUT - Mandar uma requisicao para atualizar missões
    @PutMapping
    public String atualizarMissao() {
        return "Missão atualizada com sucesso!";
    }

    // DELETE - Mandar uma requisicao para deletar missões
    @DeleteMapping
    public String deletarMissao() {
        return "Missão deletada com sucesso!";
    }


}
