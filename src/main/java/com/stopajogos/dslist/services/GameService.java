package com.stopajogos.dslist.services;

import com.stopajogos.dslist.dto.GameDTO;
import com.stopajogos.dslist.entities.Game;
import com.stopajogos.dslist.dto.GameMinDTO;
import com.stopajogos.dslist.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Injetando dependências em componentes
@Service
public class GameService {
    // Injetando uma instancia do game repository para dentro do game service (componentes chamando componentes)
    @Autowired
    private GameRepository gameRepository;

    // Garantindo a operação com boas práticas com o BD
    @Transactional(readOnly = true) /* Garantindo que não haverá uma operação de escrita no banco de dados*/
    public GameDTO findById(Long id) {
        // Recebendo um id pelo metodo abaixo e retorna um objeto game a partir do repository
        Game result = gameRepository.findById(id).get();

        // Retornando o dto após instanciá-lo como um novo Game DTO
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    // Metodo que faz o service devolve uma lista de games do tipo minDTO
    @Transactional(readOnly = true)/* Garantindo que não haverá uma operação de escrita no banco de dados*/
    public List<GameMinDTO> findAll() {
        // Consulta no banco de dados e puxando os games numa lista
        List<Game> result = gameRepository.findAll();

        // Stream() = lib do java que permite fazer ações com sequências de dados
        /* map() = metodo que "transforma itens", x é passado como argumento para fazer uma lista de games "resumidos" */
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

}
