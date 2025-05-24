package com.stopajogos.dslist;

import jakarta.persistence.*;
import java.util.Objects;
import jakarta.persistence.Entity;

// Configurando a classe Game para uma tabela relacional no nosso banco de dados. Tratando as estruturas de uma tabela
@Entity
@Table(name = "tb_game")
public class Game {
    // Criando os atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY /* Uma forma de indicar pro banco para gerar o id*/)
    private Long id;
    private String title;

    @Column(name = "game_year" /*Customizando o nome da coluna no SQL, pois year e uma palavra reservada do SQL*/)
    private Integer year; // Usamos Integer quando necessita-se de um valor nulo quando num BD
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    // Construtor vazio (evitar erro do Hibernate)
    public Game () {

    }

    // Construtor
    public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    // Metodos Getters e setters
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

    // Metodos de comparação dos games, comparação entre objetos
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        return Objects.equals(id, other.id);
    }
}

