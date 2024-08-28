package com.sxntixgxs.survey.slices.rol.domain.ports.in;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sxntixgxs.survey.slices.rol.domain.models.Rol;

@Repository
public interface RolOperations {
    void createRole(Rol rol);
    Optional<Rol> getRolById(int id);
    Optional<Rol> updateRol(Rol rol);
    void deleteRol(int id);
    List<Rol> getAllRol();

}
