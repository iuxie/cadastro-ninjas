package dev.iurexavier.CadastroDeNinjas.ninjas.controller;

import dev.iurexavier.CadastroDeNinjas.ninjas.service.NinjaService;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.model.NinjaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Hello World!";
    }

    // Criar Ninja
    @PostMapping
    public String criaNinja() {
        return "Ninja criado!";
    }

    // Listar todos os Ninjas
    @GetMapping
    public List listaNinjas() {
        return service.listaNinjas();
    }

    // Procurar Ninja por ID
    @GetMapping("/{id}")
    public NinjaModel listaNinjaPorId(@PathVariable Long id) {
        return service.listaNinjaPorId(id);
    }

    // Atualizar dados do Ninja
    @PatchMapping
    public String atualizaNinja() {
        return "Dados do Ninja alterados";
    }

    // Deletar Ninja
    @DeleteMapping
    public String deletaNinja() {
        return "Ninja deletado";
    }

}
