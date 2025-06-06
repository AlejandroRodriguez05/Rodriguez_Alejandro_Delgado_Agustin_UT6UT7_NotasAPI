/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.NotasApi.service;

import com.dam.NotasApi.model.Nota;
import com.dam.NotasApi.repository.NotaRepository;
import com.dam.NotasApi.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl extends AbstractCrudService<Nota, Long, NotaRepository> implements NotaService {

    @Autowired
    public NotaServiceImpl(NotaRepository repository) {
        super(repository);
    }

    @Override
    public List<Nota> findByUsuarioId(Long usuarioId, Sort sort) {
        return repository.findByUsuarioId(usuarioId, sort);
    }
}