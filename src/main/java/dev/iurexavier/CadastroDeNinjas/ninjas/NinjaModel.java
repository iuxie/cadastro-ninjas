package dev.iurexavier.CadastroDeNinjas.ninjas;

import dev.iurexavier.CadastroDeNinjas.missoes.MissaoModel;
import jakarta.persistence.*;
import java.util.List;

// JPA - Java Persistence API
// Entity transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_cadastro")
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

    public NinjaModel() {}

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public MissaoModel getMissao() {
        return missao;
    }

    public void setMissao(MissaoModel missao) {
        this.missao = missao;
    }

}