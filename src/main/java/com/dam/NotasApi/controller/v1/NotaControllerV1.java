/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.NotasApi.controller.v1;

import com.dam.NotasApi.model.Nota;
import com.dam.NotasApi.model.Usuario;
import com.dam.NotasApi.service.NotaService;
import com.dam.NotasApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notas")
public class NotaControllerV1 {

    private final NotaService notaService;
    private final UsuarioService usuarioService;

    @Autowired
    public NotaControllerV1(NotaService notaService, UsuarioService usuarioService) {
        this.notaService = notaService;
        this.usuarioService = usuarioService;
    }

  @GetMapping
public List<Nota> getAllNotas(@RequestParam(required = false) Long usuarioId,
                             @RequestParam(defaultValue = "asc") String order) {
    Sort.Direction direction;
    try {
        direction = Sort.Direction.fromString(order);
    } catch (IllegalArgumentException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parámetro order inválido");
    }

    Sort sort = Sort.by(direction, "fechaCreacion");

    if (usuarioId != null) {
        return notaService.findByUsuarioId(usuarioId, sort);
    }
    return notaService.getAll();
}


    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Long id) {
        Optional<Nota> nota = notaService.getById(id);
        return nota.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada"));
    }

    @PostMapping
    public ResponseEntity<Nota> createNota(@RequestParam Long usuarioId, @Valid @RequestBody Nota nota) {
        Optional<Usuario> usuario = usuarioService.getById(usuarioId);
        if (!usuario.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario no encontrado");
        }
        nota.setUsuario(usuario.get());
        Nota savedNota = notaService.save(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNota);
    }

 @PutMapping("/{id}")
public ResponseEntity<Nota> updateNota(@PathVariable Long id, @Valid @RequestBody Nota nota) {
    Optional<Nota> notaExistenteOpt = notaService.getById(id);
    if (!notaExistenteOpt.isPresent()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada");
    }
    Nota notaExistente = notaExistenteOpt.get();

    nota.setId(id);
    // Asignar el usuario original a la nota que se va a actualizar
    nota.setUsuario(notaExistente.getUsuario());

    Nota updatedNota = notaService.update(id, nota);
    return ResponseEntity.ok(updatedNota);
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Long id) {
        if (!notaService.getById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada");
        }
        notaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}



