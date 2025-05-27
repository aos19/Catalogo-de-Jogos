package com.stopajogos.dslist.controllers;

import com.stopajogos.dslist.dto.GameDTO;
import com.stopajogos.dslist.dto.GameListDTO;
import com.stopajogos.dslist.dto.GameMinDTO;
import com.stopajogos.dslist.dto.ReplacementDTO;
import com.stopajogos.dslist.services.GameListService;
import com.stopajogos.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador: porta de entrada ao backend, implementação da API se dá por ele
@RestController
// Mapear o recurso games, configurando o caminho que será respondido pela API
@RequestMapping(value = "/lists")
public class GameListController {
    // Injetando um service no controller (seguindo a ideia de camdadas e componentes no projeto)
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    // GetMapping = denota que estamos realizando uma requisição GET
    @GetMapping
    public List<GameListDTO> findAll() {
        // Consulta no banco de dados e puxando os games numa lista
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    /* Definindo o path de um endpoint para a API, acesso aos games de uma lista específica (Ação/aventura ou jogos de plataforma), identificados por seu id */
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findGames(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByGameList(listId);
        return result;
    }

    // Definindo a opere1ção POST de mudança de posição de cada game na lista (arraste)
    @PostMapping(value = "/{listId}/replacement")
        public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) /* Pegando o corpo da requisição */{
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
