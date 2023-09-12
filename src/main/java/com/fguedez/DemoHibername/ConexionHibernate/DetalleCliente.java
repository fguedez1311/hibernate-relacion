package com.fguedez.DemoHibername.ConexionHibernate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="detalles_clientes")
public class DetalleCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String web;
    private String telefono;
    private String comentarios;

    public DetalleCliente(String web, String telefono, String comentarios) {
        this.web = web;
        this.telefono = telefono;
        this.comentarios = comentarios;
    }
}
