package com.daniel.springboot.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter @Entity @Table(name = "clientes")
public class Cliente implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "No puede estar vacio") @Size(min = 4, max = 20, message = "Debe tener minimo 4 caracteres")
    @Column(nullable = false)
    private String nombre;
    @NotEmpty(message = "No puede estar vacio")
    private String apellido;
    @NotEmpty(message = "No puede estar vacio") @Email(message = "No es un correo valido")
    @Column(unique = true) //nullable
    private String email;
    @NotNull(message = "No puede estar vacio")
    @Column(name = "create_at") @Temporal(TemporalType.DATE)
    private Date createAt;
    private String foto;
    @NotNull(message = "la region no puede estar vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;
    @JsonIgnoreProperties(value = {"cliente", "hibernateLazyInitializer", "handler"}, allowSetters = true) //para evitar un loop
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Cliente(){
        this.facturas = new ArrayList<>();
    }


    private static final long serialVersionUID = 1L;

}
