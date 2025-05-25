package com.stopajogos.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_game_list")
public class GameList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public GameList() {

    }

    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Metodo que gera um hash p/ cada objeto da classe em que ele está definido, cada instância distinta de um objeto recebe um hash
    @Override
    public int hashCode() {
        // A igualdade entre objetos da classe é baseada no valor do atributo id
        return Objects.hash(id);
    }

    // Definindo a igualdade entre duas instâncias da classe GameList. Retorna false se as classes forem diferentes
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        GameList gameList = (GameList) obj;
        return Objects.equals(id, gameList.id);
    }
}
