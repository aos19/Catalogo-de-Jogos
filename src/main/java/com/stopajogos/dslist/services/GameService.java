package com.stopajogos.dslist.services;

import com.stopajogos.dslist.Game;
import com.stopajogos.dslist.dto.GameMinDTO;
import com.stopajogos.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Injetando dependências em componentes
@Service
public class GameService {
    // Injetando uma instancia do game repository para dentro do game service (componentes chamando componentes)
    @Autowired
    private GameRepository gameRepository;

    // Metodo que faz o service devolve uma lista de games do tipo minDTO
    public List<GameMinDTO> findAll() {
        // Consulta no banco de dados e puxando os games numa lista
        List<Game> result = gameRepository.findAll();

        // Stream() = lib do java que permite fazer ações com sequências de dados
        /* map() = metodo que "transforma itens", x é passado como argumento para fazer uma lista de games "resumidos" */
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

}
