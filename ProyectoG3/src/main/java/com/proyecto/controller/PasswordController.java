package com.proyecto.controller;


import com.proyecto.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

@Controller
public class PasswordController {

    @Autowired
    private User user; 

    @GetMapping("/editar-contrasena")
    public String mostrarContrasena() {

        User User = User.obtenerUsuarioActual(); 
        String currentPassword = User.getPassword();


        return "edit-password";
    }

    @PostMapping("/cambiar-contrasena")
    public ModelAndView cambiarContrasena(@RequestParam("Contrasena Actual") String currentPassword,
                                       @RequestParam("Nueva Contrasena") String newPassword) {

        ModelAndView modelAndView = new ModelAndView("redirect:/contrasena-cambiada");
        return modelAndView;
    }

    @GetMapping("/contrasena-cambiada")
    public String contrasenCambiada() {
        return "password-changed";
    }
}
