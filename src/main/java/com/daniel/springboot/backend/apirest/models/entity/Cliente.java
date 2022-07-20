package com.daniel.springboot.backend.apirest.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter @Entity @Table(name = "clientes")
public class Cliente implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "No puede estar vacio") @Size(min = 4, max = 20, message = "Debe tener minimo 4 caracteres")
    @Column(nullable = false)
    private String nombre;
    @NotEmpty(message = "No puede estar vacio")
    private String apellido;
    @NotEmpty(message = "No puede estar vacio") @Email(message = "No es un correo valido")
    @Column(nullable = false, unique = false)
    private String email;
    @Column(name = "create_at") @Temporal(TemporalType.DATE)
    private Date createAt;
    @PrePersist
    private void prePersist(){
        createAt = new Date();
    }

    private static final long serialVersionUID = 1L;

}
