package com.daniel.springboot.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity @Table(name = "facturas")
public class Factura implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String observacion;
    @Column(name = "create_at") @Temporal(TemporalType.DATE)
    private Date createAt;
    @JsonIgnoreProperties(value = {"facturas", "hibernateLazyInitializer", "handler"}, allowSetters = true) //ignorar la relacion de la contraparte y evitar loop
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private List<ItemFactura> items;

    public Double getTotal(){
        Double total = 0.00;
        for (ItemFactura item: items){
            total += item.getImporte();
        }
        return total;
    }

    public Factura(){
        items = new ArrayList<>();
    }

    @PrePersist
    public void addDate(){
        this.createAt = new Date();
    }

    private static final long serialVersionUID = 1L;
}
