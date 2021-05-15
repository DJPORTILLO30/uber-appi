package com.prouxs.UberAPI.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table (name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "id_persona")
    @NotNull
    private Long idPersona;

    @Column(name = "id_piloto")
    private Long idPiloto;

    @Column(name = "zona")
    private String zona;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private Integer monto;


    public Viaje(Long id, Long idPersona, Long idPiloto, String zona, String estado, Integer monto) {
        this.id = id;
        this.idPersona = idPersona;
        this.idPiloto = idPiloto;
        this.zona = zona;
        this.estado = estado;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Long idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }
}
