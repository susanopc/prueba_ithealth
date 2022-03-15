package com.ithealth.susano.service.impl;

import com.ithealth.susano.exception.PacienteNotFound;
import com.ithealth.susano.model.Paciente;
import com.ithealth.susano.repository.PacienteRepository;
import com.ithealth.susano.service.IPacienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Override
    public Paciente crear(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente actualizar(Long id, Paciente paciente) throws PacienteNotFound{
        consultarPorId(id);
        paciente.setId(id);
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente consultarPorId(Long id) throws PacienteNotFound{
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);        
        if(!pacienteOpt.isPresent()){
            throw new PacienteNotFound();
        }
        return pacienteOpt.get();
    }

    @Override
    public List<Paciente> consultarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public void borrar(Long id) throws PacienteNotFound{
        consultarPorId(id);
        pacienteRepository.deleteById(id);
    }
    
    
}
