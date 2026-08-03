package dev.iurexavier.CadastroDeNinjas.ninjas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.iurexavier.CadastroDeNinjas.missao.dto.MissaoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    @Schema(description = "ID do ninja", example = "1234", hidden = true, requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Nome do Ninja", example = "Naruto Uzumaki", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @Schema(description = "E-mail do Ninja", example = "naruto@email.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Schema(description = "Idade do Ninja", example = "19", requiredMode = Schema.RequiredMode.REQUIRED)
    private int idade;

    @Schema(description = "Rank do Ninja", example = "Kage")
    private String rank;

    @Schema(name = "missao_id", description = "ID da missão", example = "12")
    @JsonIgnoreProperties("ninjas")
    private MissaoDTO missao;

}
