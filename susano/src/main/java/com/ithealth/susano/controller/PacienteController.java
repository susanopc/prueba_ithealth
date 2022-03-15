package com.ithealth.susano.controller;

import com.ithealth.susano.exception.PacienteNotFound;
import com.ithealth.susano.model.Paciente;
import com.ithealth.susano.service.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
    
    @Autowired
    private IPacienteService pacienteService;
    
    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) {        
        return new ResponseEntity<>(pacienteService.crear(paciente), HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Paciente> update(@PathVariable("id") Long id, @RequestBody Paciente paciente) {           
        try {
            return new ResponseEntity<>(pacienteService.actualizar(id, paciente), HttpStatus.OK);
        } catch (PacienteNotFound ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Paciente> get(@PathVariable("id") Long id) {          
        try {
            return new ResponseEntity<>(pacienteService.consultarPorId(id), HttpStatus.OK);
        } catch (PacienteNotFound ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Paciente>> getAll() {        
        return new ResponseEntity<>(pacienteService.consultarTodos(), HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {            
        try {
            pacienteService.borrar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (PacienteNotFound ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
