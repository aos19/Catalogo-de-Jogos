package com.stopajogos.dslist.dto;

import com.stopajogos.dslist.entities.Game;
import org.springframework.beans.BeanUtils;

public class GameDTO {
    // Criando os atributos para vindos do Game, respeitando a padronização entre componentes
    private Long id;
    private String title;
    private Integer year; // Usamos Integer quando necessita-se de um valor nulo quando num BD
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO() {

    }

    // Copiando tudo o que está na entidade e trazendo para o objeto DTO, se os nomes dos campos forem os mesmos ele copia todos para o objeto
    public GameDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }
    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}

