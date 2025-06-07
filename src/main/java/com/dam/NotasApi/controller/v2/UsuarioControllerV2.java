/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.NotasApi.controller.v2;

import com.dam.NotasApi.model.Usuario;
import com.dam.NotasApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class UsuarioControllerV2 {
    
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioControllerV2(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody Usuario usuario) {
        // Verificar si el email ya existe
        if (usuarioService.findByEmail(usuario.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("El email ya está registrado");
        }
        
        // Hashear la contraseña
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));
        
        // Guardar el usuario
        Usuario usuarioGuardado = usuarioService.save(usuario);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }
}
