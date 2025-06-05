/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.NotasApi.service;

import com.dam.NotasApi.model.Usuario;
import java.util.Optional;

public interface UsuarioService extends CrudService<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}

