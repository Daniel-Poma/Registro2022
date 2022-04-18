/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.serviciosrest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.serviciosrest.entity.Cliente;

/**
 *
 * @author danip
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("select cl from Cliente cl where cl.estado='1'")
    List<Cliente> findAllCustom();  
}
