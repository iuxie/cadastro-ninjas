package dev.iurexavier.CadastroDeNinjas.ninjas.mapper;

import dev.iurexavier.CadastroDeNinjas.missao.dto.MissaoDTO;
import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import dev.iurexavier.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.model.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setRank(ninjaDTO.getRank());

        if (ninjaDTO.getMissao() != null) {
            MissaoModel missaoModel = new MissaoModel();
            missaoModel.setId(ninjaDTO.getMissao().getId());
            missaoModel.setNome(ninjaDTO.getMissao().getNome());
            missaoModel.setDificuldade(ninjaDTO.getMissao().getDificuldade());

            ninjaModel.setMissao(missaoModel);
        }

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setRank(ninjaModel.getRank());

        if (ninjaModel.getMissao() != null) {
            MissaoDTO missaoDTO = new MissaoDTO();
            missaoDTO.setId(ninjaModel.getMissao().getId());
            missaoDTO.setNome(ninjaModel.getMissao().getNome());
            missaoDTO.setDificuldade(ninjaModel.getMissao().getDificuldade());

            ninjaDTO.setMissao(missaoDTO);
        }

        return ninjaDTO;
    }
}