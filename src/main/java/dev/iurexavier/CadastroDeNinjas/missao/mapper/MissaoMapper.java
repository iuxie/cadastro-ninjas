package dev.iurexavier.CadastroDeNinjas.missao.mapper;

import dev.iurexavier.CadastroDeNinjas.missao.dto.MissaoDTO;
import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import dev.iurexavier.CadastroDeNinjas.ninjas.mapper.NinjaMapper;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class MissaoMapper {

    private final NinjaMapper ninjaMapper;

    public MissaoMapper(NinjaMapper ninjaMapper) {
        this.ninjaMapper = ninjaMapper;
    }

    public MissaoModel map(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = new MissaoModel();

        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());

        if (missaoDTO.getNinjas() != null) {
            missaoModel.setNinjas(missaoDTO.getNinjas().stream()
                    .map(ninjaMapper::map)
                    .collect(Collectors.toList()));
        }

        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        MissaoDTO missaoDTO = new MissaoDTO();

        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDificuldade(missaoModel.getDificuldade());

        if (missaoModel.getNinjas() != null) {
            missaoDTO.setNinjas(missaoModel.getNinjas().stream()
                    .map(ninjaMapper::map)
                    .collect(Collectors.toList()));
        }

        return missaoDTO;
    }
}