package dev.iurexavier.CadastroDeNinjas.ninjas.controller;

import dev.iurexavier.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.NinjaService;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.model.NinjaModel;
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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return service.criarNinja(ninja);
    }

    // Listar todos os Ninjas
    @GetMapping
    public List listarNinja() {
        return service.listarNinjas();
    }

    // Procurar Ninja por ID
    @GetMapping("/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id) {
        return service.listarNinjaPorId(id);
    }

    // Atualizar dados do Ninja
    @PutMapping("/{id}")
    public NinjaModel atualizarNinja(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        return service.atualizarNinja(id, ninja);
    }

    // Deletar Ninja
    @DeleteMapping("/{id}")
    public void deletarNinja(@PathVariable Long id) {
        service.deletarNinjaPorId(id);
    }

}
