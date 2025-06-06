/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.NotasApi.service;

import com.dam.NotasApi.model.Usuario;
import com.dam.NotasApi.repository.UsuarioRepository;
import com.dam.NotasApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends AbstractCrudService<Usuario, Long, UsuarioRepository> implements UsuarioService {

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}