package com.daniel.springboot.backend.apirest.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@Entity @Table(name = "productos")
public class Producto implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    @Column(name = "create_at") @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void addDate(){
        createAt = new Date();
    }

    private static final long serialVersionUID = 1L;
}
