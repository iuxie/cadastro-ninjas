package dev.iurexavier.CadastroDeNinjas.ninjas.service.model;

import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private int idade;

    @Column(name = "rank")
    private String rank;

    // @ManyToOne -> Um Ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missao_id") // FK (Foreign Key)
    private MissaoModel missao;

}