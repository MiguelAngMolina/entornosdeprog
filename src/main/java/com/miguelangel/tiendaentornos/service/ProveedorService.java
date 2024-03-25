package com.miguelangel.tiendaentornos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.miguelangel.tiendaentornos.model.Proveedora;
import com.miguelangel.tiendaentornos.repository.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedora> findAll() {
        return proveedorRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<Proveedora> findById(Long id) {
        return proveedorRepository.findById(id);
    }

    @SuppressWarnings("null")
    public Proveedora save(Proveedora proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @SuppressWarnings("null")
    public void deleteById(Long id) {
        proveedorRepository.deleteById(id);
    }

    @SuppressWarnings("null")
    public boolean existsById(Long id) {
        return proveedorRepository.existsById(id);
    }
    
 }
