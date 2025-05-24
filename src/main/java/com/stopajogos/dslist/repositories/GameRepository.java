package com.stopajogos.dslist.repositories;

import com.stopajogos.dslist.Game;
import org.springframework.data.jpa.repository.JpaRepository;

// Desenvolvendo a camada de acesso a dados

// Deixando o tipo da entidade como Game e Long
public interface GameRepository extends JpaRepository<Game, Long> {

}
