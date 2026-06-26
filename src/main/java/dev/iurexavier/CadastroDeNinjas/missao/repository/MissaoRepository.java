package dev.iurexavier.CadastroDeNinjas.missao.repository;

import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<MissaoModel, Long>  {
}
