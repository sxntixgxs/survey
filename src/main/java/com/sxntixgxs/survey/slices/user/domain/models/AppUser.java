package com.sxntixgxs.survey.slices.user.domain.models;

import java.util.List;

import com.sxntixgxs.survey.slices.rol.domain.models.Rol;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean enabled;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;
}   
