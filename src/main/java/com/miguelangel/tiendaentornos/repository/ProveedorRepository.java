package com.miguelangel.tiendaentornos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miguelangel.tiendaentornos.model.Proveedora;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedora, Long> {

    // Encontrar proveedores por su nombre
    List<Proveedora> findByNombre(String nombre);

    // Encontrar proveedores por la ciudad
    List<Proveedora> findByCiudad(String ciudad);

    // Encontrar proveedores por nombre y ciudad
    List<Proveedora> findByNombreAndCiudad(String nombre, String ciudad);

    // Encontrar proveedores cuyo nombre contenga una cadena de texto específica
    List<Proveedora> findByNombreContaining(String cadena);

    // Encontrar proveedores por nombre ignorando mayúsculas/minúsculas
    List<Proveedora> findByNombreIgnoreCase(String nombre);

    // Encontrar el primer proveedor ordenado por nombre
    Proveedora findFirstByOrderByNombreAsc();

    // Encontrar proveedores por ciudad y ordenarlos por nombre de forma descendente
    List<Proveedora> findByCiudadOrderByNombreDesc(String ciudad);
}
