package dev.iurexavier.CadastroDeNinjas.missao.repository;

import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoRepository extends JpaRepository<MissaoModel, Long>  {
}
