package dev.iurexavier.CadastroDeNinjas.missao.service;

import dev.iurexavier.CadastroDeNinjas.missao.dto.MissaoDTO;
import dev.iurexavier.CadastroDeNinjas.missao.mapper.MissaoMapper;
import dev.iurexavier.CadastroDeNinjas.missao.repository.MissaoRepository;
import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private final MissaoRepository repository;
    private final MissaoMapper mapper;

    public MissaoService(MissaoRepository repository, MissaoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Listar todas as missões
    public List<MissaoDTO> listarMissoes() {
        List<MissaoModel> missaoModelList = repository.findAll();
        return missaoModelList.stream()
                .map(mapper::map)
                .toList();
    }

    // Buscar Missão por ID
    public MissaoDTO procurarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoModelOptional = repository.findById(id);
        return missaoModelOptional.map(mapper::map)
                .orElse(null);
    }

    // Criar Missão
    public MissaoDTO criarMissao(MissaoDTO missao) {
        MissaoModel missaoModel = mapper.map(missao);
        missaoModel = repository.save(missaoModel);
        return mapper.map(missaoModel);
    }

    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoDTO) {
        Optional<MissaoModel> missaoModel = repository.findById(id);
        if (missaoModel.isPresent()) {
            MissaoModel missaoAtualizada = mapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            return mapper.map(repository.save(missaoAtualizada));
        }
        return null;
    }

    // Deletar Missão
    public void deletarMissao(Long id) {
        repository.deleteById(id);
    }

}
