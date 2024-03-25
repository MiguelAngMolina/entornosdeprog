package com.miguelangel.tiendaentornos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@Entity
@Table(name = "proveedor")
public class Proveedora {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ciudad", nullable = true, length = 255)
    private String ciudad;

    @Column(name = "direccion", nullable = true, length = 255)
    private String direccion;

    @Column(name = "nombre", nullable = true, length = 255)
    private String nombre;

    @Column(name = "telefono", nullable = true, length = 15)
    private String telefono;

    @Column(name = "nit", nullable = true, length = 100)
    private String nit;
    
    // Getters y Setters
    // Puedes generar estos métodos automáticamente en tu IDE o escribirlos manualmente
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
