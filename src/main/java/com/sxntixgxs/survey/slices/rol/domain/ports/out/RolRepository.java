package com.sxntixgxs.survey.slices.rol.domain.ports.out;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sxntixgxs.survey.slices.rol.domain.models.Rol;


public interface RolRepository extends JpaRepository<Rol,Integer>{
    List<Rol> findByName(String name);
    Optional<Rol> getRolById(int id);
    Optional<Rol> updateRol(Rol rol);
    void deleteRol(int id);
    List<Rol> getRolByName(String rolname);
}
