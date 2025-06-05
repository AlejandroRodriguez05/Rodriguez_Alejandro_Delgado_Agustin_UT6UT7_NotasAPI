/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.NotasApi.service;

import com.dam.NotasApi.model.Nota;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface NotaService extends CrudService<Nota, Long> {
    List<Nota> findByUsuarioId(Long usuarioId, Sort sort);
}
