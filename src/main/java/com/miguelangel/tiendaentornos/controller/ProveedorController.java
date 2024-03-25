package com.miguelangel.tiendaentornos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.miguelangel.tiendaentornos.exception.ResourceNotFoundException;
import com.miguelangel.tiendaentornos.model.Proveedora;
import com.miguelangel.tiendaentornos.service.ProveedorService;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // Obtener todos los proveedores
    @GetMapping
    public List<Proveedora> getAllProveedores() {
        return proveedorService.findAll();
    }
    




    @PostMapping
    public ResponseEntity<Proveedora> createProveedor(@RequestBody Proveedora proveedor) {
        if (proveedor == null) {
            // Manejar el caso donde el proveedor es nulo, podría ser lanzando una excepción o devolviendo un ResponseEntity adecuado
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El proveedor no puede ser nulo");
        }
        Proveedora savedProveedor = proveedorService.save(proveedor);
        return ResponseEntity.ok(savedProveedor);
    }


    // Obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedora> getProveedorById(@PathVariable(value = "id") Long proveedorId) {
        Proveedora proveedor = proveedorService.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con el id : " + proveedorId));
        return ResponseEntity.ok().body(proveedor);
    }

    // Actualizar un proveedor
    @PutMapping("/{id}")
    public ResponseEntity<Proveedora> updateProveedor(@PathVariable(value = "id") Long proveedorId,
                                                     @RequestBody Proveedora proveedorDetails) {
        Proveedora proveedor = proveedorService.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con el id : " + proveedorId));

        proveedor.setNombre(proveedorDetails.getNombre());
        // actualizar otros campos necesarios

        final Proveedora updatedProveedor = proveedorService.save(proveedor);
        return ResponseEntity.ok(updatedProveedor);
    }

    // Borrar un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable(value = "id") Long proveedorId) {
        if (!proveedorService.existsById(proveedorId)) {
            throw new ResourceNotFoundException("Proveedor no encontrado con el id : " + proveedorId);
        }

        proveedorService.deleteById(proveedorId); // Solo necesitas pasar el ID aquí
        return ResponseEntity.ok().build();
    }


}
