package com.fguedez.DemoHibername.ConexionHibernate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name="detalles_clientes")
public class DetalleCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String web;
    private String telefono;
    private String comentarios;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente elcliente;

    public DetalleCliente(String web, String telefono, String comentarios) {
        this.web = web;
        this.telefono = telefono;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Cliente getElcliente() {
        return elcliente;
    }

    public void setElcliente(Cliente elcliente) {
        this.elcliente = elcliente;
    }

    @Override
    public String toString() {
        return "DetalleCliente{" +
                "web='" + web + '\'' +
                ", telefono='" + telefono + '\'' +
                ", comentarios='" + comentarios + '\'' +
                ", elcliente=" + elcliente +
                '}';
    }
}
