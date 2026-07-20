package dev.iurexavier.CadastroDeNinjas.ninjas.service;

import dev.iurexavier.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import dev.iurexavier.CadastroDeNinjas.ninjas.mapper.NinjaMapper;
import dev.iurexavier.CadastroDeNinjas.ninjas.repository.NinjaRepository;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository repository;
    private NinjaMapper mapper;

    public NinjaService(NinjaRepository repository, NinjaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninja) {
        NinjaModel ninjaModel = mapper.map(ninja);
        ninjaModel = repository.save(ninjaModel);
        return mapper.map(ninjaModel);
    }

    // Deletar um Ninja por id - Tem que ser um método void
    public void deletarNinjaPorId(Long id) {
        repository.deleteById(id);
    }

    // Atualizar Ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (repository.existsById(id)) {
            ninjaAtualizado.setId(id);
            repository.save(ninjaAtualizado);
        }
        return null;
    }

    // TODO: Implementar método PATCH

}
