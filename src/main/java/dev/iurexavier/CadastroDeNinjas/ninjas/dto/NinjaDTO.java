package dev.iurexavier.CadastroDeNinjas.ninjas.dto;

import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;
    private MissaoModel missao;

}
