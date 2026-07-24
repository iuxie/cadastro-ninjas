package dev.iurexavier.CadastroDeNinjas.missao.controller;

import dev.iurexavier.CadastroDeNinjas.missao.dto.MissaoDTO;
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
    public List<MissaoDTO> listarMissoes() {
        return service.listarMissoes();
    }

    // GET - Buscar missões por ID
    @GetMapping("/{id}")
    public MissaoDTO procurarMissaoPorId(@PathVariable Long id) {
        return service.procurarMissaoPorId(id);
    }

    // POST - Mandar uma requisicao para criar missões
    @PostMapping
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missao) {
        return service.criarMissao(missao);
    }

    // PUT - Mandar uma requisicao para atualizar missões
    @PutMapping("/{id}")
    public MissaoDTO atualizarMissao(@PathVariable Long id, @RequestBody MissaoDTO missao) {
        return service.atualizarMissao(id, missao);
    }

    // DELETE - Mandar uma requisicao para deletar missões
    @DeleteMapping("/{id}")
    public void deletarMissao(@PathVariable Long id) {
       service.deletarMissao(id);
    }

}
