package dev.iurexavier.CadastroDeNinjas.missao.service;

import dev.iurexavier.CadastroDeNinjas.missao.repository.MissaoRepository;
import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
