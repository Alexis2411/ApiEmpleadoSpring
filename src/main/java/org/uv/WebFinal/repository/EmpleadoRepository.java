/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.WebFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uv.WebFinal.models.Empleado;

/**
 *
 * @author A24jr
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    
}
