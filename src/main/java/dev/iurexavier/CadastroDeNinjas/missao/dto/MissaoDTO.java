package dev.iurexavier.CadastroDeNinjas.missao.dto;

import dev.iurexavier.CadastroDeNinjas.ninjas.service.model.NinjaModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissaoDTO {

    @Schema(hidden = true)
    private Long id;

    @Schema(description = "Nome da Missão", example = "Salvar a vila", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @Schema(description = "Dificuldade da Missão (S-F)", example = "S", requiredMode = Schema.RequiredMode.REQUIRED)
    private String dificuldade;

    @Schema(description = "Lista de Ninjas responsáveis pela Missão")
    private List<NinjaModel> ninjas;

}
