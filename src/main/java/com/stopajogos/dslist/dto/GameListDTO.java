package com.stopajogos.dslist.dto;

import com.stopajogos.dslist.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    // Implementando somente os getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
