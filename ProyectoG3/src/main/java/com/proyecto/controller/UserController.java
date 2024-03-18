/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.controller;

import ch.qos.logback.core.model.Model;
import com.proyecto.domain.User;
import org.springframework.ui.Model;
import com.proyecto.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sebas
 */
@Controller
public class UserController {

    @Autowired
    private userService userService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var users = userService.getUser(false);
        model.addAttribute("users", users);
        model.addAttribute("totalusers", users.size());
        return "/user/listado";
    }

    @GetMapping("/nuevo")
    public String userNuevo(User user) {
        return "/user/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String userGuardar(User user,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            userService.save(user);
            user.setRuta_imagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "user",
                            user.getIdUser()));
        }
        userService.save(user);
        return "redirect:/user/listado";
    }

    @GetMapping("/eliminar/{iduser}")
    public String userEliminar(User user) {
        userService.delete(user);
        return "redirect:/user/listado";
    }

    @GetMapping("/modificar/{iduser}")
    public String userModificar(User user, Model model) {
        user = userService.getUser(user);
        model.addAttribute("user", user);
        return "/user/modifica";
    }
}
