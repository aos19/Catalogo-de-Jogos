package com.stopajogos.dslist.services;

import com.stopajogos.dslist.dto.GameDTO;
import com.stopajogos.dslist.entities.Game;
import com.stopajogos.dslist.dto.GameMinDTO;
import com.stopajogos.dslist.projections.GameMinProjection;
import com.stopajogos.dslist.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static java.util.stream.Collectors.toList;

// Injetando dependências em componentes
@Service
public class GameService {
    // Injetando uma instancia do game repository para dentro do game service (componentes chamando componentes)
    @Autowired
    private GameRepository gameRepository;

    // Garantindo a operação com boas práticas com o BD
    @Transactional(readOnly = true) /* Garantindo que não haverá uma operação de escrita no banco de dados*/
    public GameDTO findById(@PathVariable Long listId) {
        // Recebendo um id pelo metodo abaixo e retorna um objeto game a partir do repository
        Game result = gameRepository.findById(listId).get();

        // Retornando o dto após instanciá-lo como um novo Game DTO
        return new GameDTO(result);
    }

    // Metodo que faz o service devolver uma lista de games do tipo minDTO
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        // Consulta no banco de dados e puxando os games numa lista
        List<Game> result = gameRepository.findAll();

        // Stream() = lib do java que permite fazer ações com sequências de dados
        /* map() = metodo que "transforma itens", x é passado como argumento para fazer uma lista de games "resumidos" */
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    // Recebendo o id da lista e retornando os games dessa lista
    public List<GameMinDTO> findByGameList(Long listId) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);

        return games.stream().map(GameMinDTO::new).toList();
    }

}
