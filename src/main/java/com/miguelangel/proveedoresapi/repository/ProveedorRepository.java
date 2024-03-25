package com.miguelangel.proveedoresapi.repository;

import com.miguelangel.proveedoresapi.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    // Encontrar proveedores por su nombre
    List<Proveedor> findByNombre(String nombre);

    // Encontrar proveedores por la ciudad
    List<Proveedor> findByCiudad(String ciudad);

    // Encontrar proveedores por nombre y ciudad
    List<Proveedor> findByNombreAndCiudad(String nombre, String ciudad);

    // Encontrar proveedores cuyo nombre contenga una cadena de texto específica
    List<Proveedor> findByNombreContaining(String cadena);

    // Encontrar proveedores por nombre ignorando mayúsculas/minúsculas
    List<Proveedor> findByNombreIgnoreCase(String nombre);

    // Encontrar el primer proveedor ordenado por nombre
    Proveedor findFirstByOrderByNombreAsc();

    // Encontrar proveedores por ciudad y ordenarlos por nombre de forma descendente
    List<Proveedor> findByCiudadOrderByNombreDesc(String ciudad);
}
