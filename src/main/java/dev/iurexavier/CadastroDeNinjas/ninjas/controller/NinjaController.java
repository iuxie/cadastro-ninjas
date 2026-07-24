package dev.iurexavier.CadastroDeNinjas.ninjas.controller;

import dev.iurexavier.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.NinjaService;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.model.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    // Criar Ninja
    @PostMapping
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = service.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoNinja);
    }

    // Listar todos os Ninjas
    @GetMapping
    public ResponseEntity<List<NinjaDTO>> listarNinja() {
        List<NinjaDTO> ninjaList = service.listarNinjas();
        if (!ninjaList.isEmpty()) {
            return ResponseEntity.ok()
                    .body(ninjaList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    // Procurar Ninja por ID
    @GetMapping("/{id}")
    public ResponseEntity<NinjaDTO> listarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninjaDTO = service.listarNinjaPorId(id);
        if (ninjaDTO != null) {
            return ResponseEntity.ok()
                    .body(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    // Atualizar dados do Ninja
    @PutMapping("/{id}")
    public ResponseEntity<NinjaDTO> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaAtualizado = service.atualizarNinja(id, ninja);
        if (ninjaAtualizado != null) {
            return ResponseEntity.ok()
                    .body(ninjaAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    // Deletar Ninja
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        if (service.listarNinjaPorId(id) != null) {
            service.deletarNinjaPorId(id);
            return ResponseEntity.ok()
                    .body("Ninja deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja não encontrado.");
    }

}
