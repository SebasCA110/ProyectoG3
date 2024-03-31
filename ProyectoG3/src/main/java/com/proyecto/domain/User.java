/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author sebas
 */
@Data
@Entity
@Table(name = "User")
public class User implements Serializable {
    
    //Autoincrementacion de las tablas
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column (name="idUser")
    private long idUser;
    private String nombre;
    private String email;
    private String contrasena;
    private boolean activo;

    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public User obtenerUsuarioActual() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
