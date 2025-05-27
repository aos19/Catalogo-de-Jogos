package com.stopajogos.dslist.services;

import com.stopajogos.dslist.dto.GameDTO;
import com.stopajogos.dslist.dto.GameListDTO;
import com.stopajogos.dslist.dto.GameMinDTO;
import com.stopajogos.dslist.entities.Game;
import com.stopajogos.dslist.entities.GameList;
import com.stopajogos.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)/* Garantindo que não haverá uma operação de escrita no banco de dados*/
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    // Implementando a feature de arrastar a caixa de cada game
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        // Removendo um game de sua posição de origem na lista
        GameMinProjection obj = list.remove(sourceIndex);

        // Adicionando a caixa que está sendo arrastada para uma nova posição na lista
        list.add(destinationIndex, obj);

        // Definindo as variáveis de minimo e máximo do arraste, entre a posição de origem e destino de um game

        // Se a posição de origem de um game for menor que a de destino dele, então o lugar mínimo será o source index
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;

        // Lógica contrária da acima
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        // Fazendo o laço que permite o arraste das caixas de cada game
        for (int i = min; i <= max; i++) {
            // Pegando o id da lista, com o id do game na lista que assume uma posição i e que assumirá uma nova posição i
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
