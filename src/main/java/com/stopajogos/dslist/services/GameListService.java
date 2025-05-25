package com.stopajogos.dslist.services;

import com.stopajogos.dslist.dto.GameDTO;
import com.stopajogos.dslist.dto.GameListDTO;
import com.stopajogos.dslist.dto.GameMinDTO;
import com.stopajogos.dslist.entities.Game;
import com.stopajogos.dslist.entities.GameList;
import com.stopajogos.dslist.repositories.GameListRepository;
import com.stopajogos.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Injetando dependências em componentes
@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)/* Garantindo que não haverá uma operação de escrita no banco de dados*/
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

}
