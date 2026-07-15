package dev.iurexavier.CadastroDeNinjas.missao.service;

import dev.iurexavier.CadastroDeNinjas.missao.repository.MissaoRepository;
import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private final MissaoRepository repository;

    public MissaoService(MissaoRepository repository) {
        this.repository = repository;
    }

    // Listar todas as missões
    public List<MissaoModel> listarMissoes() {
        return repository.findAll();
    }

    // Buscar Missão por ID
    public MissaoModel procurarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoModelOptional = repository.findById(id);
        return missaoModelOptional.orElse(null);
    }

    // Criar Missão
    public MissaoModel criarMissao(MissaoModel missao) {
        return repository.save(missao);
    }

}
