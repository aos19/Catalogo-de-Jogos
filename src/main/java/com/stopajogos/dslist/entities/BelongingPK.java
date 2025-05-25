package com.stopajogos.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

// Embaracando dois atributos numa classe só
@Embeddable
public class BelongingPK {
    // Fazendo o mapeamento do objeto relacional com o JPA
    @ManyToOne
    @JoinColumn(name = "game_id") // Configurando o nome da FK
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public BelongingPK() {

    }

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }
    public void setList(GameList list) {
        this.list = list;
    }

    public int hashCode() {
        return Objects.hash(game, list);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        BelongingPK other = (BelongingPK) obj;
        return Objects.equals(game, other.game) && Objects.equals(list, other.list);
    }
}
