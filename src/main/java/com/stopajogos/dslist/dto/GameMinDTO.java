package com.stopajogos.dslist.dto;

import com.stopajogos.dslist.entities.Game;
import com.stopajogos.dslist.projections.GameMinProjection;

public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year; // Usamos Integer quando necessita-se de um valor nulo quando num BD
    private String imgUrl;
    private String shortDescription;

    // Adicionando um construtor vazio para instância do Hibernate
    public GameMinDTO() {

    }

    /* GameMinDTO será instanciando a partir do objeto Game, recuperando as informações do objeto "original" */
    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
