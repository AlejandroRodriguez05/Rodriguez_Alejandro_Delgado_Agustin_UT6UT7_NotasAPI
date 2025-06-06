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

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class AuthControllerV2 {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthControllerV2(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Map<String, Object>> signIn(@Valid @RequestBody Usuario usuario) {
        if (usuarioService.findByEmail(usuario.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El email ya está registrado");
        }
        // Hash de la contraseña
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));

        Usuario savedUsuario = usuarioService.save(usuario);

        Map<String, Object> response = new HashMap<>();
        response.put("id", savedUsuario.getId());
        response.put("nombre", savedUsuario.getNombre());
        response.put("email", savedUsuario.getEmail());
        response.put("message", "Usuario registrado exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

