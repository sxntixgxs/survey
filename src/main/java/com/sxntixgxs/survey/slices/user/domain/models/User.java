package com.sxntixgxs.survey.slices.user.domain.models;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.sxntixgxs.survey.slices.rol.domain.models.Rol;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private boolean enabled;
    private String username;
    private String password;
    @ManyToMany
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns=@JoinColumn(name="role_id")

        )
    private List<Rol> rolList;
}
