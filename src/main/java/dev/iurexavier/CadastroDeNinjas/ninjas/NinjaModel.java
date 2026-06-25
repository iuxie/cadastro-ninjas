package dev.iurexavier.CadastroDeNinjas.ninjas;

import dev.iurexavier.CadastroDeNinjas.missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// JPA - Java Persistence API
// Entity transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_cadastro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome, email;
    private int idade;

    // @ManyToOne -> Um Ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missao_id") // FK (Foreign Key)
    private MissaoModel missao;

}