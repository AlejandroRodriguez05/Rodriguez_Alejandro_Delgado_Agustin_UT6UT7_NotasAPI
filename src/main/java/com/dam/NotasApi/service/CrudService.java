/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.NotasApi.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    List<T> getAll();
    Optional<T> getById(ID id);
    T save(T entity);
    T update(ID id, T entity);
    void deleteById(ID id);
}