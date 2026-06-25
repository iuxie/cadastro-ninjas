package dev.iurexavier.CadastroDeNinjas.missoes;

import dev.iurexavier.CadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dificuldade;
    private NinjaModel ninja;

    public MissaoModel() {
    }

    public MissaoModel(Long id, String name, String dificuldade, NinjaModel ninja) {
        this.id = id;
        this.name = name;
        this.dificuldade = dificuldade;
        this.ninja = ninja;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

}
