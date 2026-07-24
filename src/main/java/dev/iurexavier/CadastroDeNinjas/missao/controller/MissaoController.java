package dev.iurexavier.CadastroDeNinjas.missao.controller;

import dev.iurexavier.CadastroDeNinjas.missao.dto.MissaoDTO;
import dev.iurexavier.CadastroDeNinjas.missao.service.MissaoService;
import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissaoDTO>> listarMissoes() {
        List<MissaoDTO> missaoDTOList = service.listarMissoes();
        if (!missaoDTOList.isEmpty()) {
            return ResponseEntity.ok()
                    .body(missaoDTOList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    // GET - Buscar missões por ID
    @GetMapping("/{id}")
    public ResponseEntity<MissaoDTO> procurarMissaoPorId(@PathVariable Long id) {
        MissaoDTO missaoDTO = service.procurarMissaoPorId(id);
        if (missaoDTO != null) {
            return ResponseEntity.ok()
                    .body(missaoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    // POST - Mandar uma requisicao para criar missões
    @PostMapping
    public ResponseEntity<MissaoDTO> criarMissao(@RequestBody MissaoDTO missao) {
        MissaoDTO missaoDTO = service.criarMissao(missao);
        if (missaoDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(missaoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    // PUT - Mandar uma requisicao para atualizar missões
    @PutMapping("/{id}")
    public ResponseEntity<MissaoDTO> atualizarMissao(@PathVariable Long id, @RequestBody MissaoDTO missao) {
        MissaoDTO missaoDTO = service.atualizarMissao(id, missao);
        if (missaoDTO != null) {
            return ResponseEntity.ok()
                    .body(missaoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    // DELETE - Mandar uma requisicao para deletar missões
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (service.procurarMissaoPorId(id) != null) {
            service.deletarMissao(id);
            return ResponseEntity.ok()
                    .body("Missão deletada com sucesso!");
        }
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body("Missão não encontrada.");
    }

}
