package dev.iurexavier.CadastroDeNinjas.ninjas.service;

import dev.iurexavier.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import dev.iurexavier.CadastroDeNinjas.ninjas.mapper.NinjaMapper;
import dev.iurexavier.CadastroDeNinjas.ninjas.repository.NinjaRepository;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository repository;
    private NinjaMapper mapper;

    public NinjaService(NinjaRepository repository, NinjaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Listar todos os Ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = repository.findAll();
        return ninjas.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    // Listar Ninjas por ID
    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninja = repository.findById(id);
        return ninja.map(mapper::map).orElse(null);
    }

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
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTOAtualizado) {
        Optional<NinjaModel> ninjaExistente = repository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = mapper.map(ninjaDTOAtualizado);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = repository.save(ninjaAtualizado);
            return mapper.map(ninjaSalvo);
        }
        return null;
    }

    // TODO: Implementar método PATCH

}
