package com.stopajogos.dslist.repositories;

import com.stopajogos.dslist.entities.Game;
import com.stopajogos.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
