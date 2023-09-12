package com.fguedez.DemoHibername.ConexionHibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;

    public Cliente(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_cliente")
    private  DetalleCliente detalleCliente;
}
