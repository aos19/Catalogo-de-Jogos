package com.stopajogos.dslist.controllers;

import com.stopajogos.dslist.dto.GameDTO;
import com.stopajogos.dslist.dto.GameMinDTO;
import com.stopajogos.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controlador: porta de entrada ao backend, implementação da API se dá por ele
@RestController
// Mapear o recurso games, configurando o caminho que será respondido pela API
@RequestMapping(value = "games")
public class GameController {
    // Injetando um service no controller (seguindo a ideia de camdadas e componentes no projeto)
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        // Consulta no banco de dados e puxando os games numa lista
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        // Consulta no banco de dados e puxando os games numa lista
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
