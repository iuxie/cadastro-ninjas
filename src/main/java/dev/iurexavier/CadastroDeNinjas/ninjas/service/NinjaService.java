package dev.iurexavier.CadastroDeNinjas.ninjas.service;

import dev.iurexavier.CadastroDeNinjas.ninjas.repository.NinjaRepository;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository repository;

    public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }

    // Listar todos os Ninjas
    public List<NinjaModel> listarNinjas() {
        return repository.findAll();
    }

    // Listar Ninjas por ID
    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninja = repository.findById(id);
        return ninja.orElse(null);
    }

    // Criar um novo Ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return repository.save(ninja);
    }

}
