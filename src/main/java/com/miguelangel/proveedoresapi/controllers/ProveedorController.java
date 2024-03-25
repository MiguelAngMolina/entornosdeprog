
package com.miguelangel.proveedoresapi.controllers;


import com.miguelangel.proveedoresapi.exception.ResourceNotFoundException;
import com.miguelangel.proveedoresapi.model.Proveedor;
import com.miguelangel.proveedoresapi.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores") // La base de la ruta para este controlador
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    // Crear un nuevo proveedor
    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable(value = "id") Long proveedorId) {
        Proveedor proveedor = proveedorRepository.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con el id : " + proveedorId));
        return ResponseEntity.ok().body(proveedor);
    }

    // Actualizar un proveedor
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable(value = "id") Long proveedorId,
                                                     @RequestBody Proveedor proveedorDetails) {
        Proveedor proveedor = proveedorRepository.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con el id : " + proveedorId));

        proveedor.setNombre(proveedorDetails.getNombre());
        // actualizar otros campos necesarios

        final Proveedor updatedProveedor = proveedorRepository.save(proveedor);
        return ResponseEntity.ok(updatedProveedor);
    }

    // Borrar un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable(value = "id") Long proveedorId) {
        Proveedor proveedor = proveedorRepository.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con el id : " + proveedorId));

        proveedorRepository.delete(proveedor);
        return ResponseEntity.ok().build();
    }
}
