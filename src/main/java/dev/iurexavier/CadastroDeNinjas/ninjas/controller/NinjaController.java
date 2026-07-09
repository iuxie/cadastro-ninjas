package dev.iurexavier.CadastroDeNinjas.ninjas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Hello World!";
    }

    // Criar Ninja
    @PostMapping
    public String criarNinja() {
        return "Ninja criado!";
    }

    // Listar todos os Ninjas
    @GetMapping
    public String todosOsNinjas() {
        return "Todos os Ninjas";
    }

    // Procurar Ninja por ID
    @GetMapping("/{id}")
    public String procuraNinjaPorId() {
        return "Ninja procurado por ID";
    }

    // Atualizar dados do Ninja
    @PatchMapping
    public String atualizaDadosNinja() {
        return "Dados do Ninja alterados";
    }

    // Deletar Ninja
    @DeleteMapping
    public String deletaNinja() {
        return "Ninja deletado";
    }

}
