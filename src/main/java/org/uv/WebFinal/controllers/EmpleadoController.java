/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.WebFinal.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.WebFinal.models.Empleado;
import org.uv.WebFinal.repository.EmpleadoRepository;

/**
 *
 * @author A24jr
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository repository;
    
    @GetMapping("/empleados")
    ResponseEntity<List<Empleado>> getall() {
        try {
            return ResponseEntity.ok(repository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    
    @PostMapping("/empleados")
    ResponseEntity<Empleado> newEmpleado (@RequestBody Empleado empleado){
        try {
            Empleado empleadoG = repository.save(empleado);
            return ResponseEntity.created(new URI("/empleados/"+empleadoG.getId())).body(empleadoG);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/empleados/{id}")
    ResponseEntity<Empleado> getone(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @PutMapping("/empleados/{id}")
    ResponseEntity<Empleado> update(@RequestBody Empleado empleado, @PathVariable Long id) {

        Empleado empleadoU = repository.findById(id).get();
        empleadoU.setNombre(empleado.getNombre());
        empleadoU.setDireccion(empleado.getDireccion());
        empleadoU.setTelefono(empleado.getTelefono());
        repository.save(empleadoU);
        return ResponseEntity.ok(empleadoU);

    }
    
    @DeleteMapping("/empleados/{id}")
    ResponseEntity<Empleado> delete(@PathVariable Long id){
        Empleado empleadD = repository.findById(id).get();
        repository.deleteById(id);
        
        return ResponseEntity.ok(empleadD);
    }
}
