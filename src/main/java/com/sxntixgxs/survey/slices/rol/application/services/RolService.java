package com.sxntixgxs.survey.slices.rol.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.slices.rol.domain.models.Rol;
import com.sxntixgxs.survey.slices.rol.domain.ports.in.RolOperations;
import com.sxntixgxs.survey.slices.rol.domain.ports.out.RolRepository;

@Service
public class RolService implements RolOperations{
    
    private final RolRepository repository;
    @Autowired
    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createRole(Rol rol) {
        repository.save(rol);
    }

    @Override
    public Optional<Rol> getRolById(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Rol> updateRol(Rol rol) {
        return Optional.of(repository.save(rol));
    }

    @Override
    public void deleteRol(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Rol> getAllRol() {
        return repository.getAll();
    }
}
