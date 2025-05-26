package com.stopajogos.dslist.projections;

// Arquivo que conterá metodos getters correpondentes as consultas sql. Realizando uma consulta personalidaza pelo JPA
public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

}
