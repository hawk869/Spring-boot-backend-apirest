package com.daniel.springboot.backend.apirest.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter @Entity @Table(name = "clientes")
public class Cliente implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    @Column(name = "create_at") @Temporal(TemporalType.DATE)
    private Date createAt;

    private static final long serialVersionUID = 1L;

}
