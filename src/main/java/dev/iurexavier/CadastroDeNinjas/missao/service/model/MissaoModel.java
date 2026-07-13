package dev.iurexavier.CadastroDeNinjas.missao.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String dificuldade;

    // @OneToMany -> Uma missão pode ter n Ninjas
    @OneToMany(mappedBy = "missao")
    @JsonIgnore
    private List<NinjaModel> ninjas;

}
