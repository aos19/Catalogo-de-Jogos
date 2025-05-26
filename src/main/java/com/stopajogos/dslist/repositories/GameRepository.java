package com.stopajogos.dslist.repositories;

import com.stopajogos.dslist.projections.GameMinProjection;
import com.stopajogos.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Desenvolvendo a camada de acesso a dados. Arquivo responsável por acessar o banco de dados

// Deixando o tipo da entidade como Game e Long
// Quando usamos nativequery (consulta sql pura), o seu resultado deve ser uma interface = "projection"
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")

    List<GameMinProjection> searchByList(Long listId);

}
