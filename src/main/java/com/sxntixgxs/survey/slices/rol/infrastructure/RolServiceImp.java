package com.sxntixgxs.survey.slices.rol.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.slices.rol.application.services.RolService;
import com.sxntixgxs.survey.slices.rol.domain.models.Rol;
import com.sxntixgxs.survey.slices.rol.domain.ports.in.RolOperations;
import com.sxntixgxs.survey.slices.rol.domain.ports.out.RolRepository;

@Service
public class RolServiceImp implements RolOperations{
    private final RolRepository rolRepository;
    @Autowired
    public RolServiceImp(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    @Override
    public void createRole(Rol rol) {
        rolRepository.save(rol);
    }
    @Override
    public Optional<Rol> getRolById(int id) {
        return rolRepository.findById(id);
    }
    @Override
    public Optional<Rol> updateRol(Rol rol) {
        if(
            rolRepository.findById(rol.getId()).isPresent()
        ){
            return Optional.of(rol);
        }else{
            return Optional.empty();
        }
    }
    @Override
    public void deleteRol(int id) {
        rolRepository.delete(getRolById(id).get());
    }
    @Override
    public List<Rol> getAllRol() {
        return rolRepository.getAll();
    }
}
