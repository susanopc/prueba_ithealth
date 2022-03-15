package com.ithealth.susano.service;

import com.ithealth.susano.exception.PacienteNotFound;
import com.ithealth.susano.model.Paciente;
import java.util.List;

public interface IPacienteService {
    
    Paciente crear(Paciente paciente);
    Paciente actualizar(Long id, Paciente paciente) throws PacienteNotFound;
    Paciente consultarPorId(Long id) throws PacienteNotFound;
    List<Paciente> consultarTodos();
    void borrar(Long id) throws PacienteNotFound;
    
}
