package dev.iurexavier.CadastroDeNinjas.missao.service.model;

import dev.iurexavier.CadastroDeNinjas.ninjas.service.model.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // @OneToMany -> Uma missão pode ter n Ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

}
