package com.stopajogos.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
    // Fazendo referência ao game, a sua posição e à lista
    // Não podemos ter dois atributos que representem cada PK! (conceitos de modelos relacionais em bd)

    // Fazendo alusão à classe BelongingPK que resguarda os dois atributos uma PK múltipla
    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging() {

    }

    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game); // Associando o game e list à classe Belonging
        id.setList(list);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Belonging other = (Belonging) obj;
        return Objects.equals(id, other.id);
    }
}
