package com.stopajogos.dslist.repositories;

import com.stopajogos.dslist.entities.Game;
import com.stopajogos.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    // É usada quando o tipo de ação do banco de dados não será um SELECT
    @Modifying

    // Fazendo uma consulta SQL nativa das "caixas" de cada game
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
