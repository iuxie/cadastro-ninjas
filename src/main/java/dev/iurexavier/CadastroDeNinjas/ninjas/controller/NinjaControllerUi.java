package dev.iurexavier.CadastroDeNinjas.ninjas.controller;

import dev.iurexavier.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.NinjaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService service;

    public NinjaControllerUi(NinjaService service) {
        this.service = service;
    }

    // localhost:8080/ninjas/ui
    @GetMapping
    public String listarNinja(Model model) {
        List<NinjaDTO> ninjas = service.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    @GetMapping("/{id}")
    public String deletarNinja(@PathVariable Long id) {
        service.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui";
    }

}
