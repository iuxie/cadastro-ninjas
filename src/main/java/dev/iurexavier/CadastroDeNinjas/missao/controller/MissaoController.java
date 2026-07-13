package dev.iurexavier.CadastroDeNinjas.missao.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    // GET - Mandar uma requisicao para buscar missões
    @GetMapping
    public String listaMissoes() {
        return "Missões listadas com sucesso!";
    }

    // POST - Mandar uma requisicao para criar missões
    @PostMapping
    public String criaMissao() {
        return "Missão criada com sucesso!";
    }

    // PUT - Mandar uma requisicao para atualizar missões
    @PutMapping
    public String atualizaMissao() {
        return "Missão atualizada com sucesso!";
    }

    // DELETE - Mandar uma requisicao para deletar missões
    @DeleteMapping
    public String deletaMissao() {
        return "Missão deletada com sucesso!";
    }


}
